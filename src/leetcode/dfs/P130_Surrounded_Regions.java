package leetcode.dfs;

import org.junit.Test;

public class P130_Surrounded_Regions {


    int rows;
    int cols;
    boolean[][] visited;
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (isBoundary(i, j) && board[i][j] == 'O') {
                    visited[i][j] = true;
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }


    int[][] axis = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0},
    };

    public void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'X') return;

        visited[i][j] = true;

        for (int k = 0; k < axis.length; k++) {
            int row = i + axis[k][0];
            int col = j + axis[k][1];
            if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col]) {
                dfs(board, row, col);
            }
        }
    }

    private boolean isBoundary(int i, int j) {
        return i == 0 || j == 0 ||i == rows - 1 || j == cols - 1;
    }


//    char[][] data = new char[][] {
//            {'X','O','O','O'},
//            {}
//    }

    char[][] data = new char[][] {
            {'O','O','O','O','X','X'},
            {'O','O','O','O','O','O'},
            {'O','X','O','X','O','O'},
            {'O','X','O','O','X','O'},
            {'O','X','O','X','O','O'},
            {'O','X','O','O','O','O'}
    };



    @Test
    public void Test() {
        solve(data);
    }
}
