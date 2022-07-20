package leetcode.dynamicproblem;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P313_Super_Ugly_Number {

    private static class Mem{
        public int idx; //res[i]
        private int[] res;
        public int base; //[primes]
        // res[i] * primes[i] 比较
        public Mem(int idx, int base, int[] res) {
            this.idx = idx;
            this.base = base;
            this.res = res;
        }
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Mem> queue = new PriorityQueue<>(new Comparator<Mem>() {
            @Override
            public int compare(Mem o1, Mem o2) {
                return (int) ((long) o1.base * (long) o1.res[o1.idx] - (long) o2.base * (long) o2.res[o2.idx]);
            }
        });

        int[] res = new int[n];
        res[0] = 1;

        for (int prime : primes) {
            queue.offer(new Mem(0, prime, res));
        }

        for (int i = 1; i < n; i++) {
            Mem peek = queue.peek();

            while (peek.base * peek.res[peek.idx] == res[i - 1]) {
                Mem top = queue.poll();
                queue.offer(new Mem(top.idx + 1, top.base, res));
                peek = queue.peek();
            }

            Mem top = queue.poll();
            res[i] = top.base * top.res[top.idx];
            queue.offer(new Mem(top.idx + 1, top.base, res));
        }

        return res[n - 1];
    }

    @Test
    public void test() {
        System.out.println(nthSuperUglyNumber(5911, new int[]{2,3,5,7}));
    }

}
