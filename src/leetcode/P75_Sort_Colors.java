package leetcode;


//荷兰国旗问题，快排思路简单版
public class P75_Sort_Colors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int left = -1;
        int right = nums.length;
        int cur = 0;

        while (cur < right) {
            if (nums[cur] == 0) {
                swap(nums, ++left, cur++);
            } else if (nums[cur] == 2) {
                swap(nums, --right, cur);
            } else {
                cur++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
