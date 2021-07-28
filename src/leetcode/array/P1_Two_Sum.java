package leetcode.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Chen Yu
 * @Date 2021/7/28 9:58
 */
public class P1_Two_Sum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> needMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (needMap.containsKey(num)) {
                return new int[]{needMap.get(num), i};
            }
            needMap.put(target - num, i);
        }

        return new int[]{};
    }

    @Test
    public void Test() {
    }
}
