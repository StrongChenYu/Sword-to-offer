package leetcode;

//顺时针旋转矩阵，主要是注意边界以及思想
public class P48_Rotate_Image {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int row1 = 0, row2 = matrix.length - 1;
        int col1 = 0, col2 = matrix[0].length - 1;

        int temp = 0;
        while (row2 > row1 && col2 > col1) {
            int times = col2 - col1;
            for (int i = 0; i < times; i++) {
                int topR = row1,topC = col1 + i;
                int rightR = row1 + i, rightC = col2;
                int botR = row2, botC = col2 - i;
                int leftR = row2 - i, leftC = col1;

                temp = matrix[topR][topC];
                matrix[topR][topC] = matrix[leftR][leftC];
                matrix[leftR][leftC] = matrix[botR][botC];
                matrix[botR][botC] = matrix[rightR][rightC];
                matrix[rightR][rightC] = temp;
            }

            row1++;
            col1++;
            row2--;
            col2--;
        }
    }

    public static void main(String[] args) {

        P48_Rotate_Image p = new P48_Rotate_Image();

        System.out.println("complete");
    }


}
