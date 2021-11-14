package leetcode.dfs;

import org.junit.Test;

public class P79_Word_Search {

    boolean[][] visited = null;
    int n;
    int m;
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                if (dfs(board, i, j, word, 0)) return true;
                visited[i][j] = false;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int strIdx) {
        if (board[i][j] != word.charAt(strIdx)) {
            return false;
        }

        if (strIdx == word.length() - 1) {
            return true;
        }

        boolean res = false;
        for (int k = 0; k < axis.length; k++) {
            int row = i + axis[k][0];
            int col = j + axis[k][1];

            if (row < 0 || row >= n || col < 0 || col >= m || visited[row][col]) continue;

            visited[row][col] = true;
            res |= dfs(board, row, col, word, strIdx + 1);
            visited[row][col] = false;
        }

        return res;
    }

    int[][] axis = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    private char[][] testData = {{'A','B','C','E'}};

    //,{'S','F','C','S'},{'A','D','E','E'}
    @Test
    public void Test() {
        System.out.println(exist(testData, "ABCE"));
    }
}
