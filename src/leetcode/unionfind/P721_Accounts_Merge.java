package leetcode.unionfind;

import java.util.*;

public class P721_Accounts_Merge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> mailToName = new HashMap<>();
        UnionFind unionFind = new UnionFind();
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                for (int j = i; j < account.size(); j++) {
                    unionFind.union(account.get(i), account.get(j));
                }
                mailToName.put(account.get(i), name);
            }
        }

        Map<String, HashSet<String>> nodeSet = unionFind.getNodeSet();
        List<List<String>> res = new ArrayList<>();
        for (String s : nodeSet.keySet()) {
            String name = mailToName.get(s);

            List<String> mails = new ArrayList<>(nodeSet.get(s));
            Collections.sort(mails);

            List<String> item = new ArrayList<>();
            item.add(name);
            item.addAll(mails);
            res.add(item);
        }

        return res;
    }

    public class UnionFind {
        Map<String, String> parent = new HashMap<>();
        Map<String, HashSet<String>> nodeSet = new HashMap<>();

        public String find(String node) {
            if (!parent.containsKey(node)) {
                parent.put(node, node);
                nodeSet.put(node, new HashSet<>());
                // 把这个set添加进去
                nodeSet.get(node).add(node);
            }

            String root = parent.get(node);
            while (!root.equals(parent.get(root))) {
                parent.put(root, parent.get(parent.get(root)));
                root = parent.get(root);
            }
            return root;
        }

        public void union(String node1, String node2) {
            String root1 = find(node1);
            String root2 = find(node2);

            if (!root1.equals(root2)) {
                // root2 -> root1
                // root1 是根
                parent.put(root2, root1);

                HashSet<String> root2Set = nodeSet.remove(root2);
                nodeSet.get(root1).addAll(root2Set);
            }
        }

        public Map<String, HashSet<String>> getNodeSet() {
            return nodeSet;
        }
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add(Arrays.asList("Mary","mary@mail.com"));
        accounts.add(Arrays.asList("John","johnnybravo@mail.com"));

        P721_Accounts_Merge p = new P721_Accounts_Merge();
        p.accountsMerge(accounts);
    }
}
