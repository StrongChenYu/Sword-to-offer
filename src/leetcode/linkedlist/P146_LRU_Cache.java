package leetcode.linkedlist;

import structure.ListNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class P146_LRU_Cache {

}

class LRUCache1 {

    private class MyCache extends LinkedHashMap<Integer, Integer> {

        private int capacity;
        public MyCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return this.size() > capacity;
        }
    }

    MyCache myCache;

    public LRUCache1(int capacity) {
        myCache = new MyCache(capacity);
    }

    public int get(int key) {
        return myCache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        myCache.put(key, value);
    }
}

class LRUCache2 {

    private class Node {
        public int key;
        public int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private Deque<Node> keyList;
    private int capacity;
    private int size;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
        keyList = new LinkedList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            keyList.remove(node);
            keyList.addFirst(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            keyList.remove(node);
            keyList.addFirst(node);
            return;
        }

        if (size >= capacity) {
            Node node = keyList.removeLast();
            map.remove(node.key);
            size--;
        }

        Node node = new Node(key, value);
        map.put(key, node);
        keyList.addFirst(node);
        size++;
    }
}

class LRUCache {

    private class Node {
        public int key;
        public int value;
        public Node next;
        public Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private class NodeList {
        public Node head;
        public Node tail;

        public NodeList() {
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);

            this.head.next = this.tail;
            this.tail.next = this.head;
        }

        public void remove(Node node) {
            Node pre = node.pre;
            Node next = node.next;

            pre.next = next;
            next.pre = pre;

            node.pre = null;
            node.next = null;

        }

        public void addFirst(Node node) {
            Node first = head.next;

            head.next = node;
            node.pre = head;

            first.pre = node;
            node.next = first;
        }


        public Node removeLast() {
            Node remove = tail.pre;
            Node pre = remove.pre;

            pre.next = tail;
            tail.pre = pre;

            remove.pre = null;
            remove.next = null;

            return remove;
        }
    }

    private HashMap<Integer, Node> map;
    private NodeList nodeList;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
        nodeList = new NodeList();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            nodeList.remove(node);
            nodeList.addFirst(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            nodeList.remove(node);
            nodeList.addFirst(node);
            return;
        }

        if (size >= capacity) {
            Node node = nodeList.removeLast();
            map.remove(node.key);
            size--;
        }

        Node node = new Node(key, value);
        map.put(key, node);
        nodeList.addFirst(node);
        size++;
    }
}
