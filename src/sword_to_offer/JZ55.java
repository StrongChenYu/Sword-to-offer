package sword_to_offer;

import structure.ListNode;

public class JZ55 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode head = pHead;
        if (head == null || head.next == null) return null;

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != slow) {
            if (slow.next != null) slow = slow.next;

            //fast可能为null在运行的过程中，fast可能移动到null
            if (fast != null && fast.next != null && fast.next.next != null) {
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
