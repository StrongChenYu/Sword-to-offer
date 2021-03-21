package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Chen Yu
 * @Date 2021/3/20 19:56
 */
public class JZ66 {

    int k;
    int maxRows;
    int maxCols;
    boolean[][] visited;
    int res;
    int[][] move = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };

    /**
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        k = threshold;
        maxRows = rows;
        maxCols = cols;
        res = 0;
        visited = new boolean[rows][cols];

        bfs(0, 0);
        return res;
    }

    /**
     * 广度有限搜索
     * @param row
     * @param col
     */
    public void bfs(int row, int col) {
        Queue<int[]> dfsQueue = new LinkedList<>();

        dfsQueue.offer(new int[]{row, col});
        visited[0][0] = true;
        while (!dfsQueue.isEmpty()) {
            int[] nodes = dfsQueue.poll();
            res++;

            for (int i = 0; i < move.length; i++) {
                int curRow = nodes[0] + move[i][0];
                int curCol = nodes[1] + move[i][1];

                if(checkBfsPos(curRow, curCol) && !visited[curRow][curCol]) {
                    dfsQueue.offer(new int[]{curRow, curCol});
                    visited[curRow][curCol] = true;
                }
            }
        }
    }

    /**
     * 检查bfs的条件是否满足
     * @param row
     * @param col
     * @return
     */
    public boolean checkBfsPos(int row, int col) {
        if (row < 0 || col < 0 || row >= maxRows || col >= maxCols)
            //说明到了外面，所以直接返回
            return false;

        if (check(row) + check(col) > k)
            //说明已经大于了k
            return false;



        return true;
    }

    /**
     * 深度优先搜索
     * @param row
     * @param col
     */
    public void dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= maxRows || col >= maxCols)
            //说明到了外面，所以直接返回
            return;

        if (check(row) + check(col) > k)
            //说明已经大于了k
            return;

        if (visited[row][col])
            //说明这个节点已经遍历过了，所以直接返回
            //不需要回溯，所以只需要当前状态递归即可
            return;

        res++;
        visited[row][col] = true;

        //然后向下面的节点进行遍历
        for (int i = 0; i < move.length; i++)
            dfs(row + move[i][0], col + move[i][1]);
    }

    /**
     * 计算n的每一位的和
     * @param n
     * @return
     */
    public int check(int n) {
        int sum = 0;

        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }

        return sum;
    }


    @Test
    public void testCheck() {
        Assert.assertEquals(check(10), 1);
        Assert.assertEquals(check(154), 10);

        Assert.assertEquals(movingCount(5,10,10), 21);
        Assert.assertEquals(movingCount(1,2,3), 3);
        Assert.assertEquals(movingCount(0,3,1), 1);
        Assert.assertEquals(movingCount(-1,3,1), 0);
    }
}
