package leetcode.greedy;

/**
 * @Author Chen Yu
 * @Date 2021/4/23 8:02
 */
public class P134_Gas_Station {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        int tank = 0;

        for (int i = 0; i < gas.length; i++) {
            int cur = gas[i] - cost[i];
            total += cur;
            tank += cur;
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total < 0 ? -1 : start;
    }
}
