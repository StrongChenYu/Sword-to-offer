package leetcode.sort;

import structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Chen Yu
 * @Date 2021/4/26 9:51
 */
public class P147_Insertion_Sort_List {

    public ListNode insertionSortList1(ListNode head) {
        ListNode res = new ListNode(Integer.MIN_VALUE);

        while (head != null) {
            ListNode pHead = res;
            while (pHead.next != null && pHead.next.val < head.val) {
                pHead = pHead.next;
            }
            ListNode next = head.next;
            head.next = pHead.next;
            pHead.next = head;

            head = next;
        }

        return res.next;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(Integer.MIN_VALUE);

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        while (head != null) {
            queue.offer(head);
            head = head.next;
        }

        ListNode pHead = res;
        while (!queue.isEmpty()) {
            pHead.next = queue.poll();
            pHead = pHead.next;
        }

        pHead.next = null;
        return res.next;
    }
}
