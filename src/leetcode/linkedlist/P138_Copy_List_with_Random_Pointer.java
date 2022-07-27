package leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class P138_Copy_List_with_Random_Pointer {


    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node pHead = head;
        while (pHead != null) {
            map.put(pHead, new Node(pHead.val));
            pHead = pHead.next;
        }

        pHead = head;
        while (pHead != null) {
            Node newNode = map.get(pHead);
            newNode.next = map.get(pHead.next);
            newNode.random = map.get(pHead.random);
            pHead = pHead.next;
        }

        return map.get(head);
    }


    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
