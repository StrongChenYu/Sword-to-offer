package leetcode.sort;

import java.util.Arrays;

/**
 * @Author Chen Yu
 * @Date 2021/4/28 8:45
 */
public class P164_Maximum_Gap {

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(nums[i] - nums[i - 1], res);
        }
        return res;
    }
}
