package leetcode.dfs;

import org.junit.Test;

public class P37_Sudoku_Solver {
    char[][] res = new char[9][9];
    public void solveSudoku(char[][] board) {
        boolean breakFlag = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    dfs(board, i, j);
                    breakFlag = true;
                    break;
                }
            }
            if (breakFlag) {
                break;
            }
        }

        for (int n = 0; n < 9; n++) {
            for (int m = 0; m < 9; m++) {
                board[n][m] = res[n][m];
            }
        }
    }

    // 从i,j开始解数独
    public void dfs(char[][] board, int i, int j) {
        if (i == 9 && j == 9) {
            // 说明已经填完了，返回结果
            for (int n = 0; n < 9; n++) {
                for (int m = 0; m < 9; m++) {
                    res[n][m] = board[n][m];
                }
            }
            return;
        }

        if (i == 9 || j == 9) return;

        for (char k = '1'; k <= '9'; k++) {
            // 判断有无重复
            if (isValid(board, i, j, k)) {
                board[i][j] = k;

                // 获取下一个开始的idx
                int x = i;
                int y = 0;
                boolean breakFlag = false;
                for (; x < 9; x++) {
                    for (y = 0; y < 9; y++) {
                        if (board[x][y] == '.') {
                            breakFlag = true;
                            break;
                        }
                    }
                    if (breakFlag) {
                        break;
                    }
                }

                dfs(board, x, y);
                board[i][j] = '.';

            }
        }
    }

    private boolean isValid(char[][] board, int i, int j, char in) {
        // 判断同一行
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == in) {
                return false;
            }
        }

        // 判断同一列
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == in) {
                return false;
            }
        }

        // 判断一个格子里面
        for (int k = 0; k < 9; k++) {
            int cellX = (i / 3) * 3 + (k / 3);
            int cellY = (j / 3) * 3 + (k % 3);

            if (board[cellX][cellY] == in) {
                return false;
            }
        }


        return true;
    }

    @Test
    public void test() {
        char[][] testData = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudoku(testData);
    }

    public static void main (String[] args) {
        int x = 5;
        int y = 7;
        for (; x < 9; x++) {
            for (; y < 9; y++) {

            }
        }
        System.out.println(x + ',' + y);
    }
}
