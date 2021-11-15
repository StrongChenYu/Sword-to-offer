package leetcode.linkedlist;

import structure.ListNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class P146_LRU_Cache {

    public class LRUNode {
        public Integer key;
        public Integer val;
        public LRUNode next;

        public LRUNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
//
//    public class LRUList {
//        private LRUNode head = new LRUNode(-1);
//        private LRUNode tail = null;
//        private int size = 0;
//
//        public LRUList() {
//            tail = head;
//        }
//
//        public void insert(LRUNode node) {
//            tail.next = node;
//            tail = tail.next;
//            size++;
//        }
//
//        public void remove(LRUNode node) {
//            LRUNode next = node.next;
//            if (next != null) {
//                node.val = next.val;
//                node.next = next.next;
//            }
//        }
//
//        public void removeHead() {
//            if (head.next != null) {
//                head.next = head.next.next;
//            }
//        }
//
//        public int getSize() {
//            return size;
//        }
//    }

    public class LRUCache{

        private int capacity = 0;
        private Map<Integer, LRUNode> nodeMap = new HashMap<>();
        private Deque<LRUNode> nodeList = new LinkedList<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!nodeMap.containsKey(key)) {
                return -1;
            }
            // list插入
            LRUNode lruNode = nodeMap.get(key);
            nodeList.remove(lruNode);
            nodeList.addFirst(lruNode);
            return lruNode.val;
        }

        public void put(int key, int value) {
            if (nodeMap.containsKey(key) && this.get(key) != -1) {
                nodeMap.get(key).val = value;
                return;
            }

            if (nodeList.size() == capacity) {
                // 删除头节点
                LRUNode lruNode = nodeList.removeLast();
                nodeMap.remove(lruNode.key);
            }
            LRUNode node = new LRUNode(key, value);
            nodeMap.put(key, node);
            nodeList.addFirst(node);
        }
    }
}

class MyLRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity = 0;
    public MyLRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}


class LRUCache{

    MyLRUCache cache;

    public LRUCache(int capacity) {
        cache = new MyLRUCache(capacity);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
