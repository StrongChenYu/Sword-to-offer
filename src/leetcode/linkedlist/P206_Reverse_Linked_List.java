package leetcode.linkedlist;

import structure.ListNode;

public class P206_Reverse_Linked_List {

    public ListNode reverseList(ListNode head) {
        ListNode pHead = new ListNode(-1);

        while (head != null) {
            ListNode next = head.next;

            head.next = pHead.next;
            pHead.next = head;

            head = next;
        }

        return pHead.next;
    }
}
