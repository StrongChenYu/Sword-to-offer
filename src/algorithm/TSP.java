package algorithm;
import java.util.Scanner;

/**
 * bottom-to-up方法，也就是声明空间后
 * 从下往上的填
 */
public class TSP {

    public static void main(String[] args) {

        /**
         * 读入距离数组
         */
        Scanner in = new Scanner(System.in);
        int cityNum = in.nextInt();
        int[][] dist = new int[cityNum][cityNum];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < cityNum; j++) {
                dist[i][j] = in.nextInt();
            }
        }
        in.close();


        /**
         * 节点数量是cityNum
         * 1<<(cityNum-1)
         */
        int V = 1 << (cityNum - 1);
        int[][] dp = new int[cityNum][V];
        for (int i = 0; i < cityNum; i++)  dp[i][0] = dist[i][0];

        /**
         * 填表
         */
        for (int j = 1; j < V; j++)
            for (int i = 0; i < cityNum; i++) {
                dp[i][j] = Integer.MAX_VALUE;
                //先判断在不在集合里面
                if (((j >> (i - 1)) & 1) == 0) {
                    //然后对每一个city求值
                    for (int k = 1; k < cityNum; k++) {
                        if (((j >> (k - 1)) & 1) == 1) {
                            dp[i][j] = Math.min(dp[i][j], dist[i][k] + dp[k][j ^ (1 << (k - 1))]);
                        }
                    }
                }
            }
        System.out.println(dp[0][V - 1]);
    }
}