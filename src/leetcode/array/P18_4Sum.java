package leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2;i ++) {
            if (nums[i] == nums[i + 1]) continue;

            List<List<Integer>> tempSums = threeSum(nums, i + 1, target - nums[i]);

            for (List<Integer> tempSum : tempSums) {
                tempSum.add(nums[i]);
                res.add(tempSum);
            }
        }

        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = start; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];

                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    List<Integer> tempRes = new ArrayList<>();
                    tempRes.add(nums[i]);
                    tempRes.add(nums[left]);
                    tempRes.add(nums[right]);

                    res.add(tempRes);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }

        return res;
    }


    @Test
    public void Test() {
        fourSum(new int[]{2,2,2,2}, 8);
    }
}
