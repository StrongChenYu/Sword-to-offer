package leetcode.linkedlist;

import org.junit.Test;
import structure.ListNode;

public class P24_Swap_Nodes_in_Pairs {

    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;

        ListNode pHead = res;
        while (pHead.next != null && pHead.next.next != null) {
            ListNode firstNode = pHead.next;
            ListNode secondNode = pHead.next.next;

            pHead.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            pHead = firstNode;
        }

        return res.next;
    }

}
