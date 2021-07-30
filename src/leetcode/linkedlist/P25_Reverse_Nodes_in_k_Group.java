package leetcode.linkedlist;

import org.junit.Test;
import structure.ListNode;

import java.util.List;

public class P25_Reverse_Nodes_in_k_Group {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }

        ListNode pHead = new ListNode(-1);
        pHead.next = head;

        ListNode pre = pHead;


        //move fast pointer
        while (pre != null) {

            ListNode slow = pre.next;
            ListNode fast = pre.next;

            int i = 0;
            for (; i < k && fast != null; i++) {
                fast = fast.next;
            }

            if (i < k) {
                return pHead.next;
            }

            //reverse [slow, fast)
            ListNode[] reverse = reverseList(slow, fast);
            ListNode reverseHead = reverse[0];
            ListNode reverseTail = reverse[1];

            pre.next = reverseHead;
            reverseTail.next = fast;

            pre = reverseTail;
        }

        return pHead.next;
    }

    public ListNode[] reverseList(ListNode start, ListNode end) {
        ListNode pHead = new ListNode(-1);
        ListNode tail = start;

        while (start != end) {
            ListNode next = start.next;

            start.next = pHead.next;
            pHead.next = start;

            start = next;
        }

        //{head, tail}
        return new ListNode[]{pHead.next, tail};
    }


    @Test
    public void Test() {
        ListNode head = new ListNode(1);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        ListNode end = head.next.next.next.next;

        reverseKGroup(head, 3);
    }

    public static void main(String[] args) {
        System.out.println(0 % 4);
    }
}
