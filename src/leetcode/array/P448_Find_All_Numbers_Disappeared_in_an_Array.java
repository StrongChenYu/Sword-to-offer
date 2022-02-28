package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class P448_Find_All_Numbers_Disappeared_in_an_Array {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        // 第一步先换
        for (int i = 0; i < nums.length; i++) {
            // 当前的值是num[i]
            // 他应该去的地方是num[num[i] - 1]

            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 第二步检测
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }

        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
