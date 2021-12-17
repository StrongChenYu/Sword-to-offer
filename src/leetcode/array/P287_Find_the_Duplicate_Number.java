package leetcode.array;

public class P287_Find_the_Duplicate_Number {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }
}
