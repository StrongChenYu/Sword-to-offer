package sword_to_offer;

import java.util.ArrayList;
import java.util.List;

public class JZ19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ret;

        int row1 = 0, col1 = 0;
        int row2 = matrix.length - 1, col2 = matrix[0].length - 1;

        while (row1 < row2 || col1 < col2) {
            int i = row1, j = col1;
            while (j <= col2) ret.add(matrix[i][j]);
             ret.add(matrix[i][col2]);
            for (int i = col2; i > col1; i--) ret.add(matrix[row2][i]);
            for (int i = row2; i > row1; i--) ret.add(matrix[i][col1]);

            row1++;
            col1++;

            row2--;
            col2--;
        }

        return ret;
    }

    public static void main(String[] args) {
        JZ19 jz19 = new JZ19();
//        int[][] matrix = new int[][]{
//                {1,2,3},
//                {5,6,7},
//                {9,10,11},
//                {13,14,15}
//        };

        int [][] matrix = new int[][] {
                {1,2,4,5,6}
        };

        List<Integer> is = jz19.printMatrix(matrix);

        for (int num : is) {
            System.out.println(num);
        }
    }
}
