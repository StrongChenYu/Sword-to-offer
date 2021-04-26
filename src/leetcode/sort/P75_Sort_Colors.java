package leetcode.sort;

/**
 * @Author Chen Yu
 * @Date 2021/4/26 9:38
 */
public class P75_Sort_Colors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int left = -1;
        int right = nums.length;
        int cur = 0;
        while (cur < right) {
            if (nums[cur] == 0) {
                swap(nums, cur++, ++left);
            } else if (nums[cur] == 2) {
                swap(nums, cur, --right);
            } else {
                cur++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
}
