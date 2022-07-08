package leetcode.unionfind;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class P2316_Count_Unreachable_Pairs_of_Nodes_in_an_Undirected_Graph {

    public long countPairs(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        long cnt = (long) n * (long) (n - 1) / 2;

        int[] size = uf.getSize();
        for (int num : size) {
            if (num > 1) {
                cnt -= (long) num * (long) (num - 1) / 2;
            }
        }

        return cnt;
    }


    private static class UF {
        int[] size;
        int[] parent;
        int count;

        public UF(int num) {
            size = new int[num];
            parent = new int[num];
            this.count = num;

            for (int i = 0; i < num; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int find(int node) {
            if (node != parent[node]) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        public void union(int node1, int node2) {
            int p1 = find(node1);
            int p2 = find(node2);

            if (p1 == p2) {
                return;
            }

            if (size[p1] > size[p2]) {
                parent[p2] = p1;
                size[p1] += size[p2];
                size[p2] = 1;
            } else {
                parent[p1] = p2;
                size[p2] += size[p1];
                size[p1] = 1;
            }

            this.count--;
        }

        public boolean isConnect(int node1, int node2) {
            return find(node1) == find(node2);
        }

        public int getCount() {
            return count;
        }

        public int[] getSize() {
            return size;
        }
    }

    @Test
    public void test() {
        countPairs(7, new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}});
    }
}
