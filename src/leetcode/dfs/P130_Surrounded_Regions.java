package leetcode.dfs;

import org.junit.Test;

public class P130_Surrounded_Regions {

    int[][] axis = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0},
    };

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        UnionFind unionFind = new UnionFind(n * m + 1);
        int oRoot = n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }

                int curIdx = i + m * j;
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    // 边界节点
                    unionFind.union(oRoot, curIdx);
                } else {
                    for (int k = 0; k < axis.length; k++) {
                        int row = i + axis[k][0];
                        int col = j + axis[k][1];

                        if (board[row][col] == 'O') {
                            unionFind.union(curIdx, row + col * m);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'O' && !unionFind.isConnect(i + j * m, oRoot)) {
                    board[i][j] = 'X';
                }
            }
        }
    }


    private static class UnionFind {

        int[] parents;
        public UnionFind(int totalNodes) {
            parents = new int[totalNodes];
            for (int i = 0; i < totalNodes; i++) {
                parents[i] = i;
            }
        }

        public int find(int node) {
            int root = parents[node];
            while (root != parents[root]) {
                parents[root] = parents[parents[root]];
                root = parents[root];
            }

            return root;
        }

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                parents[root1] = root2;
            }
        }

        public boolean isConnect(int node1, int node2) {
            return find(node1) == find(node2);
        }
    }

    public static void main(String[] args) {
        int n = 7;
        UnionFind unionFind = new UnionFind(7);
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++) {
                unionFind.union(i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            unionFind.find(i);
        }

        System.out.println("test end");
    }

    int rows;
    int cols;
    boolean[][] visited;
    public void solveDFS(char[][] board) {
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
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
    };



    @Test
    public void Test() {
        solve(data);
    }
}
