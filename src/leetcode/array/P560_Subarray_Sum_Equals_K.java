package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Chen Yu
 * @Date 2022/3/4 23:22
 */
public class P560_Subarray_Sum_Equals_K {

    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> preSumCntMap = new HashMap<>();

        // 前缀和为0的元素个数为0
        preSumCntMap.put(0, 1);
        int cnt = 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // 当前前缀和对应的元素+1
            Integer orDefault = preSumCntMap.getOrDefault(sum, 0);
            preSumCntMap.put(sum, orDefault + 1);

            cnt += preSumCntMap.getOrDefault(sum - k, 0);
        }

        return cnt;
    }
}
