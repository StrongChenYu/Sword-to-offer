package algorithm.sort_algorithm;

import org.junit.Test;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {

    }

    private void sort(int[] nums) {
        selectSort(nums);
    }

    private void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIdx = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            swap(nums, minIdx, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{3,2};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
