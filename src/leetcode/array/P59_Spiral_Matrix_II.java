package leetcode.array;

import org.junit.Test;

import java.util.Arrays;

public class P59_Spiral_Matrix_II {


    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int ele = 1;
        int u = 0, d = n - 1, l = 0, r = n - 1;
        while (ele <= n * n) {
            for (int j = l; j <= r; j++) {
                matrix[u][j] = ele++;
            }

            ++u;

            for (int j = u; j <= d; j++) {
                matrix[j][r] = ele++;
            }

            --r;

            for (int j = r; j >= l; j--) {
                matrix[d][j] = ele++;
            }

            --d;

            for (int j = d; j >= u; j--) {
                matrix[j][l] = ele++;
            }

            ++l;
        }

        return matrix;
    }

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(generateMatrix(5)));
    }
}
