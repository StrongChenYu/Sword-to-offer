package leetcode.greedy;

import org.junit.Test;

import java.util.*;

public class P56_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        List<int[]> temp = new ArrayList<>();

        int preStart = intervals[0][0];
        int preEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= preEnd) {
                preEnd = Math.max(preEnd, intervals[i][1]);
            } else {
                temp.add(new int[]{preStart, preEnd});

                preStart = intervals[i][0];
                preEnd = intervals[i][1];
            }
        }

        temp.add(new int[]{preStart, preEnd});

        int[][] result = new int[temp.size()][2];
        int idx = 0;
        for (int[] ints : temp) {
            result[idx++] = ints;
        }

        return result;
    }

    int[][] data = {{1,3},{2,6},{8,10},{15,18}};

    @Test
    public void test() {
        merge(data);
    }
}
