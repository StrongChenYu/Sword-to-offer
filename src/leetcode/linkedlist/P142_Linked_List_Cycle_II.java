package leetcode.linkedlist;

import structure.ListNode;

public class P142_Linked_List_Cycle_II {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != slow) {
            if (slow.next != null) slow = slow.next;

            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
        }

        //运行到这里说明有环
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
