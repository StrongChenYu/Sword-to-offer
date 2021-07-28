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
        for (int i = 0; i <= nums.length - 4; i++) {
            int num = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> threeSums = threeSum(nums, i + 1, target - num);
            for (List<Integer> threeSum : threeSums) {
                threeSum.add(num);
                res.add(threeSum);
            }
        }

        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int startIdx, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = startIdx; i < n; i++) {

            if (i > startIdx && nums[i] == nums[i - 1]) {
                continue;
            }

            int L = i + 1;
            int R = n - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == target) {
                    List<Integer> tempRes = new ArrayList<>();
                    tempRes.add(nums[i]);
                    tempRes.add(nums[L]);
                    tempRes.add(nums[R]);
                    res.add(tempRes);

                    while (L<R && nums[L] == nums[L+1]) L++;
                    while (L<R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                } else if (sum < target) {
                    L++;
                } else {
                    R--;
                }
            }
        }

        return res;
    }

    @Test
    public void Test() {
        fourSum(new int[]{1,0,-1,0,-2,2}, 0);
    }
}
