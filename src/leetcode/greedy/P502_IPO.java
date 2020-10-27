package leetcode.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P502_IPO {

    public class PCNum {
        public int profits;
        public int capital;

        public PCNum(int profits, int capital) {
            this.profits = profits;
            this.capital = capital;
        }
    }


    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        //capital 默认是最小堆
        PriorityQueue<PCNum> capitalQueue = new PriorityQueue<>(new Comparator<PCNum>() {
            @Override
            public int compare(PCNum pcNum, PCNum t1) {
                return pcNum.capital - t1.capital;
            }
        });

        //profits is max heap
        PriorityQueue<PCNum> profitQueue = new PriorityQueue<>(new Comparator<PCNum>() {
            @Override
            public int compare(PCNum pcNum, PCNum t1) {
                return t1.profits - pcNum.profits;
            }
        });


        int n = Capital.length;
        for (int i = 0; i < n; i++) {
            capitalQueue.offer(new PCNum(Profits[i], Capital[i]));
        }


        int cnt = 0;
        int maxW = W;
        PCNum tempNode;
        do {

            while ((tempNode = capitalQueue.peek()) != null && tempNode.capital <= maxW) {
                profitQueue.offer(capitalQueue.poll());
            }
            cnt++;
            tempNode = profitQueue.poll();
            if (tempNode == null) break;
            maxW += tempNode.profits;
        } while (cnt < k);

        return maxW;
    }


    public static void main(String[] args) {

        P502_IPO p = new P502_IPO();
        int[] Profit = new int[]{1,2,3};
        int[] Capital = new int[]{0,1,1};
        System.out.println(p.findMaximizedCapital(20, 4, Profit, Capital));
//        PriorityQueue<Integer> capitalQueue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer integer, Integer t1) {
//                return t1 - integer;
//            }
//        });
//
//        capitalQueue.offer(1);
//        capitalQueue.offer(10);
//        capitalQueue.offer(4);
//        capitalQueue.offer(12);
//
//        while (!capitalQueue.isEmpty()) {
//            System.out.println(capitalQueue.poll());
//        }
    }
}
