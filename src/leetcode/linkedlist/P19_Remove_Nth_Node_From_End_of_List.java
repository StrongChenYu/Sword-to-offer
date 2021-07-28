package leetcode.linkedlist;

import structure.ListNode;

/**
 * @Author Chen Yu
 * @Date 2021/7/28 12:42
 */
public class P19_Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pHead = head;
        ListNode pDelete = head;

        ListNode mem = new ListNode(-1);
        mem.next = head;
        head = mem;

        //fisrt move pHead
        for (int i = 1; i < n && pHead != null; i++) {
            pHead = pHead.next;
        }

        while (pHead != null) {
            if (pHead.next == null) {
                //删除pDelete节点
                mem.next = pDelete.next;
                return head.next;
            } else {
                pHead = pHead.next;
                pDelete = pDelete.next;
                mem = mem.next;
            }
        }

        return head.next;
    }
}
