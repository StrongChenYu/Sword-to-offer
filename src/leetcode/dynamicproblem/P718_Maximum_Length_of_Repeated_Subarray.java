package leetcode.dynamicproblem;

import org.junit.Test;

public class P718_Maximum_Length_of_Repeated_Subarray {


    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[][] dp = new int[n1][n2];

        int maxCnt = 0;


        for (int i = 0; i < n1; i++) {
            for(int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j]) {
                    // 如果相等，那么说明要dp一下
                    if (i - 1 < 0 || j - 1 < 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    maxCnt = Math.max(dp[i][j], maxCnt);
                }
            }
        }

        return maxCnt;
    }

    @Test
    public void test() {
        System.out.println(findLength(new int[]{0}, new int[]{1}));
    }
}
