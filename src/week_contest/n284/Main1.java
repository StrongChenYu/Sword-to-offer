package week_contest.n284;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main1 {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();

        int lastRight = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];

            if (cur == key) {
                // [i - k, i + k]
                int left = Math.max(i - k, lastRight);
                int right = Math.min(i + k + 1, nums.length);
                for (int j = left; j < right; j++) {
                    res.add(j);
                }
                lastRight = right;
            }
        }

        return res;
    }

    @Test
    public void test() {
    }

    public static void main(String[] args) {
    }
}
