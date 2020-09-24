package sword_to_offer;

public class JZ16 {

    //简单一次过
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode h1 = list1;
        ListNode h2 = list2;
        ListNode ret = new ListNode(0);
        ListNode head = ret;

        while (h1 != null && h2 != null) {
            if (h1.val > h2.val) {
                ret.next = new ListNode(h2.val);
                h2 = h2.next;
            } else {
                ret.next = new ListNode(h1.val);
                h1 = h1.next;
            }
            ret = ret.next;
        }

        if (h1 != null) ret.next = h1;
        if (h2 != null) ret.next = h2;

        return head.next;
    }

}
