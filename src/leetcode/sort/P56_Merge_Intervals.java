package leetcode.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Chen Yu
 * @Date 2021/4/25 19:00
 */
public class P56_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> dRes = new ArrayList<>();
        int cur = 0;
        int n = intervals.length;
        while (cur < n) {

            int[] tempRes = new int[2];
            tempRes[0] = intervals[cur][0];
            tempRes[1] = intervals[cur][1];

            int i = cur + 1;
            for (; i < n; i++) {
                int[] interval = intervals[i];

                if (tempRes[1] >= interval[0]) {
                    //区间合并
                    tempRes[1] = Math.max(interval[1], tempRes[1]);
                } else {
                    break;
                }
            }
            dRes.add(tempRes);
            cur = i;
        }
        return dRes.toArray(new int[dRes.size()][]);
    }

    int[][] testData = {
            {1,3}
    };

    @Test
    public void Test() {
        merge(testData);
    }
}
