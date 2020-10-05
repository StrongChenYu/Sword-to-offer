package leetcode.linkedlist;

import structure.ListNode;

//判断链表是否有环
public class P141_Linked_List_Cycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode fast = head;
        ListNode slow = head;

        while (slow.next != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }

        return false;
    }
}
