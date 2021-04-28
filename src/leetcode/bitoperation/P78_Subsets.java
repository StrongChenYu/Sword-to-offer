package leetcode.bitoperation;

import org.junit.Test;
import structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Chen Yu
 * @Date 2021/4/28 9:15
 */
public class P78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        int end = (1 << n);
        for (int i = 0; i < end; i++) {
            int idx = i;
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((idx & 1) == 1) {
                    temp.add(nums[j]);
                }
                idx = (idx >>> 1);
            }
            res.add(temp);
        }
        return res;
    }

    @Test
    public void Test() {
        subsets(new int[]{1,2,3});
    }
}
