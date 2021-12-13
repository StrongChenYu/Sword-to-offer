package leetcode.tree;

import org.junit.Test;

public class P208_Implement_Trie_Prefix_Tree {

    @Test
    public void Test() {
        Trie trie = new Trie();
        trie.insert("chenyu");

        System.out.println(trie.search("chen"));
        System.out.println(trie.startsWith("ch"));
        System.out.println(trie.startsWith("chen"));
        System.out.println(trie.search("chenyu"));
    }
}

class Trie {

    // isEnd用来表示当前的节点是不是末尾节点
    private static class TrieNode {
        public boolean isEnd = false;
        public TrieNode[] tries = new TrieNode[26];
        public TrieNode() { }
    }

    TrieNode root = new TrieNode();
    public Trie() {

    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i] - 'a';
            if (cur.tries[idx] == null) {
                cur.tries[idx] = new TrieNode();
            }
            cur = cur.tries[idx];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i] - 'a';
            cur = cur.tries[idx];
            if (cur == null) {
                return false;
            }
        }

        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i] - 'a';
            cur = cur.tries[idx];
            if (cur == null) {
                return false;
            }
        }

        return true;
    }
}