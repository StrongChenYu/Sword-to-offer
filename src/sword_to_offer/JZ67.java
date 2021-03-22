package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Chen Yu
 * @Date 2021/3/22 9:44
 */
public class JZ67 {


    Map<Integer, Integer> dpMap = new HashMap<>();

    /**
     * 递归然后保存状态
     * @param target
     * @return
     */
    public int cutRope_Recursion(int target) {
        if (target == 2) return 1;
        if (dpMap.containsKey(target)) return dpMap.get(target);

        int max = 0;
        for (int i = 1; i < target; i++) {
            int res = cutRope_Recursion(target - i);
            //System.out.println("cutRope("+ (target - i) + ") : " + res);
            max = Math.max(i * res, max);
            max = Math.max(i * (target - i), max);
        }

        dpMap.put(target, max);
        return max;
    }

    public int cutRope(int target) {
        if (target <= 2) return 1;

        int[] dp = new int[target + 1];
        dp[2] = 1;

        for (int i = 3; i <= target; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(Math.max(dp[i - j] * j, (i - j) * j), max);
            }
            dp[i] = max;
        }
        //printArray(dp);
        return dp[target];
    }

    private void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    @Test
    public void Test() {
        Assert.assertEquals(cutRope(8),18);
        Assert.assertEquals(cutRope(4),4);
        Assert.assertEquals(cutRope(2),1);
        Assert.assertEquals(cutRope(3),2);
    }


}
