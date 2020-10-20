package leetcode;

public class P547_Friend_Circles {

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return 0;

        int n = M.length;
        int m = M[0].length;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    cnt++;
                    infect(M, i, j, n, m);
                }
            }
        }

        return cnt;
    }


    public void infect(int[][] M, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || M[i][j] == 0 || M[i][j] == 2) return;

        M[i][j] = 2;
        infect(M, i, j + 1, n, m);
        infect(M, i + 1, j, n, m);
        infect(M, i, j - 1, n, m);
        infect(M, i - 1, j, n, m);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}
        };

        P547_Friend_Circles p = new P547_Friend_Circles();
        System.out.println(p.findCircleNum(matrix));
    }
}
