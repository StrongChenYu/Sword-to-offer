package leetcode.unionfind;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author Chen Yu
 * @Date 2021/10/22 23:47
 */
public class P684_Redundant_Connection {


    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(1001);

        for (int i = 0; i < edges.length; i++) {
            int e1 = edges[i][0];
            int e2 = edges[i][1];

            if (uf.isConnected(e1, e2)) {
                return edges[i];
            }

            uf.union(e1, e2);
        }

        return new int[]{};
    }

    private static class UF {
        int[] parent;

        public UF(int n) {
            parent = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);

            if (root1 == root2) {
                return;
            }

            parent[root1] = root2;
        }

        public int find(int node) {
            if (node != parent[node]) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        public boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }
    }
}
