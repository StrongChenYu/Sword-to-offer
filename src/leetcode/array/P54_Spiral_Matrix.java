package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class P54_Spiral_Matrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int d = matrix.length - 1;
        int r = matrix[0].length - 1;

        int u = 0;
        int l = 0;

        while (true) {
            for (int i = l; i <= r; i++) {
                result.add(matrix[u][i]);
            }
            if (++u > d) break;

            for (int i = u; i <= d; i++) {
                result.add(matrix[i][r]);
            }

            if (--r < l) break;

            for (int i = r; i >= l; i--) {
                result.add(matrix[d][i]);
            }

            if (--d < u) break;

            for (int i = d; i >= u; i--) {
                result.add(matrix[i][l]);
            }

            if (++l > r) break;
        }

        return result;
    }

}
