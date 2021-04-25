package leetcode.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Chen Yu
 * @Date 2021/4/25 19:35
 */
public class P57_Insert_Interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[][]{newInterval};
        }

        //初始化的时候就已经排好序了没必要
        //Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> dRes = new ArrayList<>();
        int n = intervals.length;
        boolean addNewFlag =false;
        for (int i = 0; i < n; i++) {
            int[] curInter = intervals[i];

            //merge intervals
            if (newInterval[1] < curInter[0]) {
                //说明没有重叠区间
                if(!addNewFlag) {
                    dRes.add(newInterval);
                    addNewFlag = true;
                }
                dRes.add(curInter);

            } else if (newInterval[0] > curInter[1]){
                //说明没有重叠区间
                dRes.add(curInter);
            } else {
                newInterval[0] = Math.min(newInterval[0], curInter[0]);
                newInterval[1] = Math.max(newInterval[1], curInter[1]);
            }
        }
        if (!addNewFlag) dRes.add(newInterval);
        return dRes.toArray(new int[dRes.size()][]);
    }

    int[][] testData = {
            {2,5},{6,7},{8,9}
    };

    @Test
    public void Test() {
        insert(testData, new int[]{0,1});
    }

}
