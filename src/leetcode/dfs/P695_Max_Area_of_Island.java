package leetcode.dfs;

import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/10/26 23:01
 */
public class P695_Max_Area_of_Island {

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int res = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = 0;
                    dfs(i, j, grid, visited);
                    res = Math.max(maxArea, res);
                }
            }
        }
        return res;
    }

    int maxArea = 0;

    public void dfs(int row, int col, int[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] != 1 || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        maxArea++;

        for (int i = 0; i < move.length; i++) {
            dfs(row + move[i][0], col + move[i][1], grid, visited);
        }
    }

    int[][] move = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    int[][] testData = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}
    };
    @Test
    public void Test() {
        System.out.println(maxAreaOfIsland(testData));
    }
}
