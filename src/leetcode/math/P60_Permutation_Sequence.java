package leetcode.math;

import org.junit.Test;

import java.util.HashSet;

public class P60_Permutation_Sequence {

    public String getPermutation(int n, int k) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            nums[i] = nums[i - 1] * i;
            builder.append(i);
        }

        int gapN = n;
        StringBuilder res = new StringBuilder();
        while (builder.length() != 0) {
            int firstIdx = 1;
            for(; firstIdx * nums[gapN - 1] < k; firstIdx++);

            res.append(builder.charAt(firstIdx - 1));
            builder.deleteCharAt(firstIdx - 1);


            k -= nums[gapN - 1] * (firstIdx - 1);
            gapN--;
        }


        return res.toString();
    }


    @Test
    public void test() {
        System.out.println(getPermutation(2, 2));
    }
}
