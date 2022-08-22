package algorithm.sort_algorithm;

import org.junit.Test;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {

    }

    private void sort(int[] nums) {
        insertSort(nums);
    }

    private void insertSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int insert = nums[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] > insert) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = insert;
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{2,1,1,1,1,1,1,1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
