package leetcode.dynamicproblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class P1235_Maximum_Profit_in_Job_Scheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] mem = new int[n + 1][3];

        mem[0][0] = 0;
        mem[0][1] = 0;
        mem[0][2] = 0;
        for (int i = 1; i < n + 1; i++) {
            mem[i][0] = startTime[i - 1];
            mem[i][1] = endTime[i - 1];
            mem[i][2] = profit[i - 1];
        }

        Arrays.sort(mem, Comparator.comparingInt(o -> o[1]));
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            int[] item = mem[i];

            // 这里可以优化成二分查找
//            int j = i - 1;
//            while (mem[j][1] > item[0]) {
//                j--;
//            }
            //[left, right)
            int right = i;
            int left = 0;
            while (left < right) {
                int middle = left + ((right - left) >> 1);
                if (mem[middle][1] <= item[0]) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            left = left - 1;

            dp[i] = Math.max(dp[i - 1], dp[left] + mem[i][2]);
        }


        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(jobScheduling(new int[]{1,2,3,4,6}, new int[]{3,5,10,6,9}, new int[]{20,20,100,70,60}));
        System.out.println(jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70}));
        System.out.println(jobScheduling(new int[]{1,1,1}, new int[]{2,3,4}, new int[]{5,6,4}));
    }

    public static void main(String[] args) {

    }
}
