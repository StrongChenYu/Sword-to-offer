package algorithm.multi_thread;

import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerModel {

    public static void main(String[] args) {
        ProducerConsumerModel model = new ProducerConsumerModel(10);

        int n = 10;
        Thread[] producer = new Thread[n];
        Thread[] consumer = new Thread[n];

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            producer[i] = new Thread(() -> {
                try {
                    while (true) {
                        model.produce();
                        System.out.println("producer " + finalI + " produce 1 ele");
                        Thread.sleep(10000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            consumer[i] = new Thread(() -> {
                try {
                    while (true) {
                        model.consumer();
                        System.out.println("consumer " + finalI + " consumer 1 ele");
                        Thread.sleep(10000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            producer[i].start();
            consumer[i].start();
        }
    }

    private ProducerConsumerModel(int capacity) {
        this.capacity = capacity;
    }

    private final Object lock = new Object();
    private int element = 0;
    private int capacity;

    private void produce() throws InterruptedException {
        synchronized (lock) {
            while (element >= capacity) {
                lock.wait();
            }

            element++;
            lock.notifyAll();
        }
    }

    private void consumer() throws InterruptedException {
        synchronized (lock) {
            while (element <= 0) {
                lock.wait();
            }

            element--;
            lock.notifyAll();
        }
    }

    public void demo1() {
        LinkedBlockingDeque<Object> queue = new LinkedBlockingDeque<>();

        int n = 10;
        Thread[] producer = new Thread[n];
        Thread[] consumer = new Thread[n];

        for (int i = 0; i < n; i++) {
            producer[i] = new Thread(new Producer(queue, i));
            consumer[i] = new Thread(new Consumer(queue, i));
        }

        for (int i = 0; i < n; i++) {
            producer[i].start();
            consumer[i].start();
        }
    }
}

class Producer implements Runnable {

    LinkedBlockingDeque<Object> queue;
    int tag;

    public Producer(LinkedBlockingDeque<Object> queue, int tag) {
        this.queue = queue;
        this.tag = tag;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.offer(new Object());
                System.out.println("producer " + this.tag + " produce a object");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    LinkedBlockingDeque<Object> queue;
    int tag;

    public Consumer(LinkedBlockingDeque<Object> queue, int tag) {
        this.queue = queue;
        this.tag = tag;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.take();
                System.out.println("consumer " + this.tag + " consume a object");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}