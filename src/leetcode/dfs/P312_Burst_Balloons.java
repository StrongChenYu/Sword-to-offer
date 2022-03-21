package leetcode.dfs;

import org.junit.Test;

public class P312_Burst_Balloons {


    public int maxCoins(int[] nums) {
        int n = nums.length + 2;


        int[][] dp = new int[n][n];
        // 为了保存bound

        for (int i = 3; i <= n; i++) {
            // i为区间长度
            // j为index
            for (int j = 0; j + i - 1 < n; j++) {
               // leftIdx = j
               int rightIdx = j + i - 1;
               //j 为leftIdx
               //j - 1 为数组中的值
               for (int k = j + 1; k <= rightIdx - 1; k++) {
                   int numIdx = k - 1;

                   int leftNumsIdx = j - 1;
                   int rightNumsIdx = rightIdx - 1;

                   int pre = leftNumsIdx >= 0 ? nums[leftNumsIdx] : 1;
                   int next = rightNumsIdx < nums.length ? nums[rightNumsIdx] : 1;

                   dp[j][rightIdx] = Math.max(dp[j][rightIdx], dp[j][k] + dp[k][rightIdx] + nums[numIdx] * pre * next);
                }
            }
        }

        return dp[0][n - 1];
    }

    @Test
    public void test() {
        System.out.println(maxCoins(new int[]{3}));
    }


    int max = 0;
    public int maxCoinsDfs(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, 0);
        return max;
    }

    private void dfs(int[] nums,  boolean[] visited, int curCoin) {

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            int find = 0;
            for (find = i - 1; find >= 0 && visited[find]; find--);
            int pre = find >= 0 ? nums[find] : 1;

            for (find = i + 1; find < nums.length && visited[find]; find++);
            int next = find < nums.length ? nums[find] : 1;

            int cur = nums[i] * pre * next;
            curCoin += cur;
            max = Math.max(curCoin, max);

            visited[i] = true;
            dfs(nums, visited, curCoin);
            curCoin -= cur;
            visited[i] = false;
        }
    }


}
