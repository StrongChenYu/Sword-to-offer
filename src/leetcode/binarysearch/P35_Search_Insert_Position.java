package leetcode.binarysearch;

public class P35_Search_Insert_Position {

    // 其实就是寻找第一个大于等于该target的position
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        // 搜索区间不为空
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }
}
