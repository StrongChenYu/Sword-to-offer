package leetcode.bitoperation;

/**
 * @Author Chen Yu
 * @Date 2021/4/28 9:35
 */
public class P137_Single_Number_II {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < 32; j++) {
                count[j] += (num & 1);
                num >>>= 1;
            }
        }

        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= count[31 - i] % m;
        }
        return res;
    }
}
