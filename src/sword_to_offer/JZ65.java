package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/3/19 13:37
 */
public class JZ65 {

    char[][] map;
    boolean[][] visited;
    int mapRows;
    int mapCols;
    public boolean hasPath (String matrix, int rows, int cols, String str) {
        // write code here
        if (str == null || str.length() == 0) return true;
        if (matrix == null || matrix.length() == 0 || rows * cols != matrix.length()) return false;

        visited = new boolean[rows][cols];
        //转化成矩阵
        transformToMatrix(matrix, rows, cols);

        //找到起始节点然后遍历
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] == str.charAt(0)) {
                    visited[i][j] = true;
                    boolean res = dfs(i, j, str, 1, str.length());
                    if (res) {
                        return res;
                    } else {
                        visited[i][j] = false;
                    }
                }
            }
        }

        return false;
    }

    int[][] pos = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    public boolean dfs(int rowId, int colId, String str, int start, int end) {
        //字符串是空的说明不管神马情况，都是true
        if (start >= end) return true;

        //到这里的时候，说明一样，并且没有被遍历过，所以可以进行下一层的遍历
        for (int i = 0; i < pos.length; i++) {
            int afRowId = rowId + pos[i][0];
            int afColId = colId + pos[i][1];

            if (afRowId >= 0 && afColId >= 0 && afRowId < mapRows && afColId < mapCols) {
                if (map[afRowId][afColId] == str.charAt(start) && !visited[afRowId][afColId]) {
                    visited[afRowId][afColId] = true;
                    boolean dfs = dfs(afRowId, afColId, str, start + 1, end);
                    if (dfs) {
                        return true;
                    } else {
                        visited[afRowId][afColId] = false;
                    }
                }
            }
        }
        return false;
    }

    private void transformToMatrix(String matrix, int rows, int cols) {
        map = new char[rows][cols];
        for (int i = 0; i < matrix.length(); i++) {
            int rowI = (i / cols);
            int colI = (i % cols);
            //System.out.println(rowI + " " + colI);
            map[rowI][colI] = matrix.charAt(i);
        }
        mapRows = rows;
        mapCols = cols;
    }


    @Test
    public void Test() {
        Assert.assertTrue(hasPath("ABCESFCSADEE",3,4,"ABCCED"));
        Assert.assertFalse(hasPath("ABCESFCSADEE",3,4,"ABCB"));
        Assert.assertTrue(hasPath("ABCESFCSADEE",3,4,"ABCESEEDASF"));
        Assert.assertTrue(hasPath("ABCCSFCSADEE",3,4,"ABCCSCF"));
        Assert.assertFalse(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS",5,8,"SGGFIECVAASABCEHJIGQEMS"));

        //边界
        Assert.assertTrue(hasPath("ABCESFCSADEE",3,4,""));
        Assert.assertTrue(hasPath("", 0, 0 , ""));
        Assert.assertFalse(hasPath("", 0, 0 , "abc"));
        Assert.assertTrue(hasPath("", 0, 0 ,""));
    }

    public static void main(String[] args) {
        int row = 4;
        int col = 3;
        for (int i = 0; i < 12; i++) {
            int rowI = (i / col);
            int colI = (i % col);
            System.out.println("row = " + (rowI) + " col = " + (colI));
        }
    }
}
