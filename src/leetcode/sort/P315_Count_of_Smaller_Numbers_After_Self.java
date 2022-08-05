package leetcode.sort;

import org.junit.Test;

import java.util.*;

public class P315_Count_of_Smaller_Numbers_After_Self {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] idxNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res.add(0);
            idxNums[i] = i;
        }

        mergeCount(nums, idxNums, 0, nums.length, res);
        return res;
    }

    private void mergeCount(int[] nums, int[] idxNums, int left, int right, List<Integer> res) {
        if (right - left <= 1) {
            return;
        }

        int middle = left + ((right - left) >> 1);
        mergeCount(nums, idxNums, left, middle, res);
        mergeCount(nums, idxNums, middle, right, res);
        merge(nums, idxNums, left, middle, right, res);
    }

    private void merge(int[] nums, int[] idxNums, int left, int middle, int right, List<Integer> res) {
        int[] temp = new int[right - left];

        int leftIdx = left;
        int rightIdx = middle;
        int tempIdx = 0;
        while (leftIdx < middle && rightIdx < right) {
            if (nums[idxNums[leftIdx]] <= nums[idxNums[rightIdx]]) {
                // = 的时候一定是左边的先出，因为这样才能统计到比=的元素大的情况
                temp[tempIdx++] = idxNums[leftIdx];

                // 已经出去的右边元素大小
                int rightCnt = rightIdx - middle;
                // 所以只要左边出的时候，已经有rightCnt个元素比他小，所以直接加就行了
                res.set(idxNums[leftIdx], res.get(idxNums[leftIdx]) + rightCnt);
                leftIdx++;
            } else {
                // >
                temp[tempIdx++] = idxNums[rightIdx++];
            }
        }


        while (leftIdx < middle) {
            temp[tempIdx++] = idxNums[leftIdx];

            int rightCnt = right - middle;
            res.set(idxNums[leftIdx], res.get(idxNums[leftIdx]) + rightCnt);
            leftIdx++;
        }

        while (rightIdx < right) {
            temp[tempIdx++] = idxNums[rightIdx++];
        }

        for (int i = 0; i < temp.length; i++) {
            idxNums[left + i] = temp[i];
        }
    }


    @Test
    public void test() {
        System.out.println(countSmaller(new int[]{5,2,6,1}));
        System.out.println(countSmaller(new int[]{-1}));
        System.out.println(countSmaller(new int[]{-1,-1}));
    }

    public static void main(String[] args) {

    }

}
