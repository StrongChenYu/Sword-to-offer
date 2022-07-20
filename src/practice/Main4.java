package practice;

import java.util.HashMap;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] words = new String[n];
        Trie tree = new Trie();

        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
            tree.insert(words[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(tree.startWith(words[i]));
        }
    }



    public static class TreeNode {
        public HashMap<Character, TreeNode> nodes;
        public boolean isEnd;
        public int cnt;

        public TreeNode() {
            nodes = new HashMap<>();
        }
    }

    public static class Trie {
        private TreeNode root;

        public Trie() {
            root = new TreeNode();
        }

        public void insert(String word) {
            TreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.nodes.containsKey(c)) {
                    node.nodes.put(c, new TreeNode());
                }
                node = node.nodes.get(c);
                node.cnt++;
            }

            node.isEnd = true;
        }

        public String startWith(String word) {
            TreeNode node = root;
            int i;
            for (i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                node = node.nodes.get(c);

                if (node.cnt == 1) {
                    break;
                }
            }

            return i + 1 <= word.length() ? word.substring(0, i + 1) : word;
        }

    }

}
