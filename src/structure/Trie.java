package structure;

public class Trie {

    public class TrieNode {
        public int pathCount;
        public int endCount;
        public TrieNode[] nextNodes;

        public TrieNode() {
            nextNodes = new TrieNode[26];
            this.pathCount = 0;
            this.endCount = 0;
        }

        public TrieNode(int pathCount, int endCount) {
            nextNodes = new TrieNode[26];
            this.pathCount = 0;
            this.endCount = endCount;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] words = word.toCharArray();
        TrieNode node = root;

        for (int i = 0; i < words.length; i++) {
            int index = words[i] - 'a';
            TrieNode nextNode = node.nextNodes[index];
            if (nextNode == null) {
                node.nextNodes[index] = new TrieNode();
            }
            node.nextNodes[index].pathCount++;
            node = node.nextNodes[index];
        }

        node.endCount = 1;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] words = word.toCharArray();
        TrieNode node = root;

        for (int i = 0; i < words.length; i++) {
            int index = words[i] - 'a';
            TrieNode nextNode = node.nextNodes[index];
            if (nextNode == null) return false;

            node = node.nextNodes[index];
        }

        return node.endCount == 1;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] words = prefix.toCharArray();
        TrieNode node = root;

        for (int i = 0; i < words.length; i++) {
            int index = words[i] - 'a';
            TrieNode nextNode = node.nextNodes[index];
            if (nextNode == null) return false;

            node = node.nextNodes[index];
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apccc");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("ap")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }


//
//    public static void main(String[] args) {
//        String str = "fjaeeoiefhaoghohgoahgoaewhoighaewoghoiaewgiohaewogia";
//        int times = 10000000;
//        char[] cs = str.toCharArray();
//
//        long start;
//        long end;
//
//        start = System.currentTimeMillis();
//        for (int i = 0; i < times; i++) {
//            test1(str);
//        }
//        end = System.currentTimeMillis();
//
//        System.out.println("str.length() cost:"+(end - start));
//
//
//        start = System.currentTimeMillis();
//        for (int i = 0; i < times; i++) {
//            test2(cs);
//        }
//        end = System.currentTimeMillis();
//        System.out.println("str to char[] cost:"+(end - start));
//
//    }
//
//    public static void test1(String str) {
//        int n = str.length();
//        for (int i = 0; i < n; i++) {
//            char a = str.charAt(i);
//        }
//    }
//
//    public static void test2(char[] cs) {
//
//        int n = cs.length;
//        for (int i = 0; i < n; i++) {
//            char a = cs[i];
//        }
//    }
}


