package sword_to_offer;

public class JZ15 {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;


        ListNode a = head;
        ListNode b = head.next;
        ListNode c = head.next.next;

        head.next = null;
        while (c != null) {
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }

        b.next = a;
        return b;
    }
}
