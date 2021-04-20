package leetcode.linkedlist;

import structure.ListNode;

/**
 * @Author Chen Yu
 * @Date 2021/4/20 9:25
 */
public class P23_Merge_k_Sorted_Lists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;

        for (int i = 0; i < lists.length; i++) {
            res = mergeTwoLists(res, lists[i]);
        }

        return res;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode head = res;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            res = res.next;
        }

        res.next = l1 != null ? l1 : l2;
        return head.next;
    }
}
