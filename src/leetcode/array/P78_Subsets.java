package leetcode.array;

import java.util.*;

public class P78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        if (nums == null || nums.length == 0) return res;

        return Recursion(nums, 0);
    }

    public List<List<Integer>> Recursion(int[] nums, int startIndex) {
        if (startIndex == nums.length - 1) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());

            List<Integer> tempRes = new ArrayList<>();
            tempRes.add(nums[startIndex]);
            res.add(tempRes);

            return res;
        }


        int curNum = nums[startIndex];
        List<List<Integer>> postRes = Recursion(nums, startIndex + 1);

        //先把后面的结果加进去
        List<List<Integer>> res = new ArrayList<>(postRes);
        for (List<Integer> list : postRes) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(curNum);

            res.add(newList);
        }

        return res;
    }

    public static void main(String[] args) {
//        List<Integer> nums = new ArrayList<>();
//
//        nums.add(1);
//        nums.add(2);
//        nums.add(3);
//
//        List<Integer> numsCopy = new ArrayList<>(nums);
//        numsCopy.remove(1);
//        System.out.println(nums);
//        System.out.println(numsCopy);

        int[] nums = new int[]{1,2};
        P78_Subsets p = new P78_Subsets();
        System.out.println(p.subsets(nums));
    }
}
