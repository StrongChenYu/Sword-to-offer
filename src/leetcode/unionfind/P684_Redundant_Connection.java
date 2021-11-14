package leetcode.unionfind;

import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/10/22 23:47
 */
public class P684_Redundant_Connection {

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length + 1);

        for (int i = 0; i < edges.length; i++) {
            int e1 = edges[i][0];
            int e2 = edges[i][1];
            if (unionFind.isConnect(e1, e2)) {
                return new int[]{edges[i][0], edges[i][1]};
            }
            unionFind.union(e1, e2);
        }
        return null;
    }

    public static class UnionFind {
        int[] parent;

        public UnionFind(int nodeNums) {
            parent = new int[nodeNums];
            for (int i = 0; i < nodeNums; i++) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            int par = parent[node];
            while(par != parent[par]) {
                parent[par] = parent[parent[par]];
                par = parent[par];
            }
            return par;
        }

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);

            if (root1 != root2) {
                parent[root1] = root2;
            }
        }

        public boolean isConnect(int node1, int node2) {
            return find(node1) == find(node2);
        }
    }

    int[][] test = {
            {1,2}, {1,3}, {2,3}
    };

    @Test
    public void Test() {
        findRedundantConnection(test);
    }
}
