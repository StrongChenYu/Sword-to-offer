package leetcode.tree;

import org.junit.Test;

public class P211_Design_Add_and_Search_Words_Data_Structure {
    @Test
    public void test() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search("dad"));
        System.out.println(wordDictionary.search("mad"));
        System.out.println(wordDictionary.search("m"));
        System.out.println(wordDictionary.search("...."));
    }
}

class WordDictionary {

    private class Node {
        public Node[] nodes;
        public boolean isEnd;

        public Node() {
            this.isEnd = false;
            this.nodes = new Node[26];
        }
    }

    Node root;
    public WordDictionary() {
        root = new Node();
        root.isEnd = true;
    }

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.nodes[idx] == null) {
                node.nodes[idx] = new Node();
            }
            node = node.nodes[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(Node node, String word, int idx) {
        if (node.isEnd && idx == word.length()) {
            return true;
        }

        if (idx >= word.length()) {
            return false;
        }

        boolean flag = false;
        if (word.charAt(idx) == '.') {
            // 这部要考虑所有的情况
            for (Node n : node.nodes) {
                if (n != null) {
                    flag |= dfs(n, word, idx + 1);
                    if (flag) {
                        // 提前返回
                        return true;
                    }
                }
            }
        } else {
            int i = word.charAt(idx) - 'a';
            if (node.nodes[i] == null) {
                return false;
            } else {
                flag = dfs(node.nodes[i], word, idx + 1);
            }
        }

        return flag;
    }

}
