package leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class P435_Non_overlapping_Intervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 默认从第二个区间开始
        // 这个计数是为了统计不重叠区间的个数
        // intervals - cnt 就是需要移除的空间个数
        int cnt = 1;
        int preEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < preEnd) {
                // 这说明这个区间和前一个存在交集
                // cnt是为了计算不重复的区间个数
                // 重复区间的第一个区间会使得cnt+1
                // 所以这里不需要重复计数
                continue;
            }
            cnt++;
            preEnd = intervals[i][1];
        }

        return intervals.length - cnt;
    }

}
