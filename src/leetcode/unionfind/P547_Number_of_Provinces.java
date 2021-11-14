package leetcode.unionfind;

import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/10/24 23:10
 */
public class P547_Number_of_Provinces {

    private int[] parent = null;
    private int numOfProvince = 0;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        parent = new int[n];
        numOfProvince = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return numOfProvince;
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
            numOfProvince--;
        }
    }

    int[][] testData = {{1,1,0},{1,1,0},{0,0,1}};

    @Test
    public void Test() {
        System.out.println(findCircleNum(testData));
    }

}
