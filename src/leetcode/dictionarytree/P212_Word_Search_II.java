package leetcode.dictionarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P212_Word_Search_II {

    public List<String> findWords(char[][] board, String[] words) {
        TrieTree trieTree = new TrieTree();
        for (String word : words) {
            trieTree.insert(word);
        }

        int n = board.length;
        int m = board[0].length;
        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[n][m];
        TreeNode node = trieTree.root;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char nextChar = board[i][j];
                if (node.nodes[nextChar - 'a'] != null) {
                    visited[i][j] = true;
                    inBoard(board, i, j, n, m, node.nodes[nextChar - 'a'], visited, res);
                    visited[i][j] = false;
                }
            }
        }

        return new ArrayList<>(res);
    }

    public void inBoard(char[][] board, int i, int j, int n, int m, TreeNode node, boolean[][] visited, Set<String> res) {
        if (!node.endWord.equals("")) {
            res.add(node.endWord);
        }

        for (int k = 0; k < axis.length; k++) {
            int newI = axis[k][0] + i;
            int newJ = axis[k][1] + j;

            if (newI < 0 || newI >= n || newJ < 0 || newJ >= m || visited[newI][newJ]) {
                continue;
            }

            char nextChar = board[newI][newJ];
            if (node.nodes[nextChar - 'a'] != null) {
                visited[newI][newJ] = true;
                inBoard(board, newI, newJ, n, m, node.nodes[nextChar - 'a'], visited, res);
                visited[newI][newJ] = false;
            }
        }
    }

    private int[][] axis = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    private static class TreeNode {
        public TreeNode[] nodes;
        public String endWord;

        public TreeNode() {
            this.nodes = new TreeNode[26];
            this.endWord = "";
        }
    }

    private static class TrieTree {
        TreeNode root;

        public TrieTree() {
            this.root = new TreeNode();
        }

        public void insert(String word) {
            TreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.nodes[idx] == null) {
                    node.nodes[idx] = new TreeNode();
                }

                node = node.nodes[idx];
            }

            node.endWord = word;
        }
    }



    @Test
    public void test() {
        System.out.println(findWords(new char[][]{{'a'}}, new String[]{"a"}));
    }
}
