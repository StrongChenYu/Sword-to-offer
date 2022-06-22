package leetcode.linkedlist;

import structure.ListNode;

public class P92_Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pHead = head;
        ListNode res = new ListNode(-1);
        ListNode tail = res;

        // 首先找到reverse的地方
        for (int i = 0; i < left - 1; i++) {
            // 把pHead放到res里面，尾插
            tail.next = pHead;
            tail = tail.next;

            pHead = pHead.next;
        }

        // 这里注意要开始反转了，头插
        int cnt = right - left + 1;
        ListNode reverseTail = pHead;
        for (int i = 0; i < cnt; i++) {
            ListNode next = pHead.next;

            pHead.next = tail.next;
            tail.next = pHead;

            pHead = next;
        }

        if (reverseTail != null) {
            reverseTail.next = pHead;
        }

        return res.next;
    }
}
