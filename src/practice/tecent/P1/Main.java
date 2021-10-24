package practice.tecent.P1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Chen Yu
 * @Date 2021/10/24 23:26
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dataNum = scanner.nextInt();

        for (int i = 0; i < dataNum; i++) {
            int cnt = scanner.nextInt();
            UnionFind unionFind = new UnionFind();
            for (int j = 0; j < cnt; j++) {
                unionFind.union(scanner.nextInt(), scanner.nextInt());
            }
            System.out.println(unionFind.getMaxCnt());
        }
    }


    private static class UnionFind {
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> element = new HashMap<>();
        int maxCnt = 1;

        public UnionFind() {

        }

        public int find(int node) {
            Integer root = parent.get(node);

            if (root == null) {
                element.put(node, 1);
                parent.put(node, node);
                return node;
            }

            while (!root.equals(parent.get(root))) {
                int granPar = parent.get(parent.get(root));
                parent.put(root, granPar);
                root = parent.get(root);
            }
            return root;
        }

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                parent.put(root1, root2);
                int sum = element.get(root2) + element.get(root1);
                maxCnt = Math.max(maxCnt, sum);
                element.put(root2, sum);
            }
        }

        public int getMaxCnt() {
            return maxCnt;
        }
    }
}
