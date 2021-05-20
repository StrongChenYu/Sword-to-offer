package leetcode.array;

import org.junit.Test;

import java.util.Arrays;

public class P16_3Sum_Closest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int closet = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + cur;

                if (Math.abs(closet) > Math.abs(sum - target) ) {
                    closet = sum - target;
                    res = sum;
                }

                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return sum;
                }

            }
        }

        return res;
    }


    @Test
    public void Test() {
        System.out.println(threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));
    }
}
