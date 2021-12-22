package leetcode.dynamicproblem;

import org.junit.Test;

public class P300_Longest_Increasing_Subsequence {
    // O(N^2) solution
    public int lengthOfLIS(int[] nums) {
        //dp 记录当前最长的子序列是什么
        int[] dp = new int[nums.length];
        //r 记录当前最长的子序列的长度
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = 0;
            int r = res;
            while (l < r) {
                int middle = ((r - l) >> 1) + l;
                if (dp[middle] < nums[i]) {
                    l = middle + 1;
                } else {
                    r = middle;
                }
            }
            dp[l] = nums[i];
            if (l == res) {
                res++;
            }
        }

        return res;
    }

    @Test
    public void Test() {
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}
