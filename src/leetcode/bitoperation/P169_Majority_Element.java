package leetcode.bitoperation;

import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/4/30 19:37
 */
public class P169_Majority_Element {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int major = 0;
        int majorCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (majorCount == 0) {
                major = nums[i];
            }
            majorCount += (nums[i] == major) ? 1 : -1;
        }

        return major;
    }

    @Test
    public void Test() {
        majorityElement(new int[]{3,2,3,3,3,3,3,3,3,3,1,1,2,3,4});
    }
}
