package leetcode.bitoperation;

/**
 * @Author Chen Yu
 * @Date 2021/4/28 9:30
 */
public class P136_Single_Number {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
