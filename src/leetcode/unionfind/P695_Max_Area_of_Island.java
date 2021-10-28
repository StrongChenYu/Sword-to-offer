package leetcode.unionfind;

/**
 * @Author Chen Yu
 * @Date 2021/10/25 23:25
 */
public class P695_Max_Area_of_Island {
    int[] parent = null;
    int[] area = null;
    int[][] move = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };
    int maxArea = 0;
    public int maxAreaOfIslandUnionFind(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        parent = new int[n * m];
        area = new int[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int curIdx = i * m + j;
                    parent[curIdx] = curIdx;
                    area[curIdx] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int elIdx = i * m + j;
                if (grid[i][j] == 0) {
                    continue;
                }
                //union
                for (int k = 0; k < move.length; k++) {
                    int curRow = i + move[k][0];
                    int curCol = j + move[k][1];
                    int curIdx = curRow * m + curCol;
                    if (curRow < 0 || curRow >= n || curCol < 0 || curCol > m || grid[curRow][curCol] == 0) {
                        continue;
                    }
                    union(elIdx, curIdx);
                }
            }
        }
        return maxArea;
    }


    public int find(int node) {
        int root = parent[node];
        while (root != parent[root]) {
            parent[root] = parent[parent[root]];
            root = parent[root];
        }
        return root;
    }

    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 != root2) {
            parent[root1] = root2;
            area[root2] += area[root1];
            maxArea = Math.max(area[root2], maxArea);
        }
    }
}
