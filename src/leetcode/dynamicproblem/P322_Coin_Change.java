package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class P322_Coin_Change {

    /**
     * 不只要获取结果，还要获取方案
     * @param coins
     * @param amount
     * @return
     */
    private Map<Integer, List<Integer>> statusMap;
    public List<Integer> coinChange_ListChange(int[] coins, int amount) {
        statusMap = new HashMap<>();
        return helpFuncGetList(coins, amount);
    }

    /**
     * 关键在于想一想回溯的条件到底代表什么情况，想一想边界
     * @param coins
     * @param amount
     * @return
     */
    private List<Integer> helpFuncGetList(int[] coins, int amount) {
        if (amount <= 0) return new ArrayList<>();
        //如果是0, 说明已经被计算过一次了，不是0的话，需要迭代计算
        if (statusMap.containsKey(amount)) return statusMap.get(amount);

        List<Integer> res = new ArrayList<>();

        int sizeMin = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int left = amount - coins[i];
            List<Integer> leftRes = helpFuncGetList(coins, left);

            if (left < 0) continue;

            if (left == 0) {
                res.clear();
                res.add(coins[i]);
                break;
            }

            if (leftRes.size() > 0 && (1 + leftRes.size()) < sizeMin) {
                res.clear();
                res.add(coins[i]);
                res.addAll(leftRes);
                sizeMin = res.size();
            }
        }

        // 这里缓存一下结果，防止重复计算
        statusMap.put(amount, res);
        return res;
    }

    @Test
    public void getCoinListTest() {
        int[][] testCoins = new int[][] {
                {1,2,5}, //正确性测试
                {1}, //边界测试
                {}, //边界测试
                {1,2,5}, //大数字测试(是否会超时)
                {2,4}, //找不到的数字测试
        };

        int[] amount = new int[]{
                11,
                2,
                2,
                100,
                11,
        };

        int[][] result = new int[][] {
                {1,5,5},
                {1,1},
                {},
                {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
                {}
        };

        for (int i = 0; i < amount.length; i++) {
            List<Integer> correctData = new ArrayList<>();
            for (int j = 0; j < result[i].length; j++) {
                correctData.add(result[i][j]);
            }
            System.out.println("第" + (i + 1) + "个" + "测试用例通过");;
            Assert.assertEquals(coinChange_ListChange(testCoins[i], amount[i]),correctData);
        }
    }

    /**
     * 迭代 记录 方法
     * 从1-n的顺序计算，最后返回结果
     * 由于第n个状态，对前面的某个状态有依赖，所以必须要有一个O(n)的空间复杂度
     * @param coins
     * @param amount
     * @return
     */
    private int[] iterStatus;
    public int coinChange(int[] coins, int amount) {
        iterStatus = new int[amount + 1];
        return helpFunc(coins, amount);
    }

    public int helpFunc(int [] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        //如果是0, 说明已经被计算过一次了，不是0的话，需要迭代计算
        if (iterStatus[amount] != 0) return iterStatus[amount];

        int minCoin = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int left = amount - coins[i];
            int res = helpFunc(coins, left);

            //这里必须判断，因为MAX_VALUE+1越界了，变成负数
            if (res == Integer.MAX_VALUE) continue;

            if (res != -1) minCoin = Math.min(minCoin, res + 1);
        }

        // 这里缓存一下结果，防止重复计算
        iterStatus[amount] = minCoin;
        return minCoin != Integer.MAX_VALUE ? minCoin : -1;
    }

    /**
     * bottom to up 方法
     * 此方法作为测试用例正确结果，因为这个方法可以保证正确
     * 由于第n个状态，对前面的某个状态有依赖，所以必须要有一个O(n)的空间复杂度
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_BottomToUp(int[] coins, int amount) {
        if (amount <= 0) return 0;
        int[] status = new int[amount + 1];
        status[0] = 0;

        for (int cur = 1; cur <= amount; cur++) {
            int minCoin = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int leftAmount = cur - coins[j];
                if (leftAmount >= 0 && status[leftAmount] != -1)
                    minCoin = Math.min(minCoin, 1 + status[leftAmount]);
            }
            status[cur] = minCoin == Integer.MAX_VALUE ? -1 : minCoin;
        }

        return status[amount];
    }


    @Test
    public void Test() {
        Assert.assertEquals(coinChange(new int[]{2,4}, 11), -1);
        Assert.assertEquals(coinChange(new int[]{1,2,5}, 11), 3);
        Assert.assertEquals(coinChange(new int[]{1}, 2), 2);
        Assert.assertEquals(coinChange(new int[]{1}, 1), 1);
        Assert.assertEquals(coinChange(new int[]{1,2,5}, 100), coinChange_BottomToUp(new int[]{1,2,5}, 100));
    }

}
