package week_contest.n284;


import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main3 {


    public int maximumTop(int[] nums, int k) {
        if (k == 0) return nums[0];
        if (nums.length == 1 && (k & 1) == 1) {
            return -1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        queue.offer(-1);
        int idx = 0;
        for (int cnt = 0; cnt < k - 1; cnt++) {
            queue.offer(nums[idx++]);
            if (idx >= nums.length) {
                return queue.poll();
            }
        }

        int heapMax = queue.poll();
        if (idx + 1 < nums.length) {
            heapMax = Math.max(nums[idx + 1], heapMax);
        }

        return heapMax;
    }

    int[][] data = {
            {20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}
    };

    @Test
    public void test() {
//        System.out.println(maximumTop(new int[]{35, 43, 23, 86, 23, 45, 84, 2, 18, 83, 79, 28, 54, 81, 12, 94, 14, 0, 0, 29, 94, 12, 13, 1, 48, 85, 22, 95, 24, 5, 73, 10, 96, 97, 72, 41, 52, 1, 91, 3, 20, 22, 41, 98, 70, 20, 52, 48, 91, 84, 16, 30, 27, 35, 69, 33, 67, 18, 4, 53, 86, 78, 26, 83, 13, 96, 29, 15, 34, 80, 16, 49, 15}, 15));
        System.out.println(maximumTop(new int[]{4,6,1,0,6,2,4}, 0));
        System.out.println(maximumTop(new int[]{35}, 3));
        System.out.println(maximumTop(new int[]{68,76,53,73,85,87,58,24,48,59,38,80,38,65,90,38,45,22,3,28,11}, 1));
        System.out.println(maximumTop(new int[]{98, 91, 17}, 2));
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue.offer(0);
        queue.offer(1);

        System.out.println(queue.poll());
    }
}
