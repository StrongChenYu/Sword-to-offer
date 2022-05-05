package leetcode.heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1005_Maximize_Sum_Of_Array_After_K_Negations {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.offer(num);
            sum += num;
        }

        while (k > 0) {
            int cur = queue.peek();
            if (cur > 0) {
                if (k >= 2) {
                    // if >= 2 keep
                    k -= 2;
                } else {
                    sum -= 2 * cur;
                    return sum;
                }
            } else if (cur < 0) {
                sum += 2 * (-cur);
                queue.poll();
                queue.offer(-cur);
                // <0 使用一次k
                k--;
            } else {
                return sum;
            }
        }

        return sum;
    }

    @Test
    public void test() {
        Assert.assertEquals(15, largestSumAfterKNegations(new int[]{-1,-2,-3,-4,-5}, 7));
        Assert.assertEquals(5, largestSumAfterKNegations(new int[]{4,2,3}, 1));
        Assert.assertEquals(6, largestSumAfterKNegations(new int[]{3,-1,0,2}, 3));
        Assert.assertEquals(13, largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2));
        Assert.assertEquals(12, largestSumAfterKNegations(new int[]{2,4,5,1,0}, 123));
        Assert.assertEquals(26, largestSumAfterKNegations(new int[]{1,3,2,6,7,9}, 3));
    }
}
