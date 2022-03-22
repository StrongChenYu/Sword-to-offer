package leetcode.math;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class P36_Valid_Sudoku {

    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[10];
        int[] col = new int[10];
        int[] cell = new int[10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 第i行
                int rowIdx1 = i;
                int rowIdx2 = j;

                // 第j列
                int colIdx1 = j;
                int colIdx2 = i;

                // 第i个格子
                int cellIdx1 = (i / 3) * 3 + (j / 3);
                int cellIdx2 = (i % 3) * 3 + (j % 3);

                if (board[rowIdx1][rowIdx2] != '.') {
                    row[board[rowIdx1][rowIdx2] - '0']++;
                    if (row[board[rowIdx1][rowIdx2] - '0'] > 1) return false;
                }

                if (board[colIdx1][colIdx2] != '.') {
                    col[board[colIdx1][colIdx2] - '0']++;
                    if (col[board[colIdx1][colIdx2] - '0'] > 1) return false;
                }

                if (board[cellIdx1][cellIdx2] != '.') {
                    cell[board[cellIdx1][cellIdx2] - '0']++;
                    if (cell[board[cellIdx1][cellIdx2] - '0'] > 1) return false;
                }
            }

            row = new int[10];
            col = new int[10];
            cell = new int[10];
        }

        return true;
    }

    @Test
    public void Test() {
        isValidSudoku(null);
    }

}
