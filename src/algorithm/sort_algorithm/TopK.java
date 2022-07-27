package algorithm.sort_algorithm;

import org.junit.Test;

import java.util.Random;

public class TopK {

    public int findKthLargest(int[] nums, int k) {

        return topKRange(nums, 0, nums.length, k);
    }

    private int topKRange(int[] nums, int left, int right, int k) {
        int idx = new Random().nextInt(right - left) + left;
        int target = nums[idx];
        int[] partition = partition(nums, left, right, target);

        int leftCnt = partition[0] - left;
        int middleCnt = partition[1] - partition[0];
        int rightCnt = right - partition[1];

        if (k <= leftCnt) {
            return topKRange(nums, left, partition[0], k);
        } else if (k <= leftCnt + middleCnt) {
            return target;
        } else {
            return topKRange(nums, partition[1], right, k - leftCnt - middleCnt);
        }
    }

    private int[] partition(int[] nums, int left, int right, int target) {
        int l = left;
        int r = right;

        // = [l, r)
        // < [left, l)
        // > [r, right)
        int cur = left;
        while (cur < r) {
            if (nums[cur] < target) {
                swap(nums, cur, --r);
            } else if (nums[cur] > target) {
                swap(nums, cur++, l++);
            } else {
                cur++;
            }
        }

        return new int[]{l, r};
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        System.out.println(findKthLargest(new int[]{1, 2, 30, 4, 5, 6}, 3));
        System.out.println(findKthLargest(new int[]{1}, 1));
        System.out.println(findKthLargest(new int[]{1,2}, 2));
        System.out.println(findKthLargest(new int[]{1,1,1,1,1,1}, 3));
        System.out.println(findKthLargest(new int[]{6,5,4,3,2,1}, 3));
    }
}
