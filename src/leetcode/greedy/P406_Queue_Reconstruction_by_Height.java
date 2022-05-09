package leetcode.greedy;

import org.junit.Test;

import java.util.*;

public class P406_Queue_Reconstruction_by_Height {

    public int[][] reconstructQueue(int[][] people) {
        List<int[]> temp = new LinkedList<>();

        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        for (int i = 0; i < people.length; i++) {
            heap.offer(people[i]);
        }

        while (!heap.isEmpty()) {
            int[] ele = heap.poll();
            temp.add(ele[1], ele);
        }

        int[][] result = new int[people.length][2];
        int idx = 0;
        for (int[] ints : temp) {
            result[idx++] = ints;
        }

        return result;
    }

    int[][] data = {
            {7,0},{4,4},{7,1},{5,0},{6,1},{5,2}
    };

    @Test
    public void test() {
        reconstructQueue(data);
    }
}
