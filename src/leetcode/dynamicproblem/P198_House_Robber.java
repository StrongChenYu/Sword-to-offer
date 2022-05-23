package leetcode.dynamicproblem;

public class P198_House_Robber {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dpStole = new int[n];
        int[] dpNotStole = new int[n];

        dpStole[0] = nums[0];
        dpNotStole[0] = 0;

        for (int i = 1; i < n; i++) {
            dpStole[i] = Math.max(dpNotStole[i - 1] + nums[i], dpStole[i - 1]);
            dpNotStole[i] = Math.max(dpStole[i - 1], dpNotStole[i - 1]);
        }

        return Math.max(dpStole[n - 1], dpNotStole[n - 1]);
    }
}
