package leetcode.linkedlist;

import structure.ListNode;

public class P234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        //这个的目的只是为了找到中点
        while (slow.next!= null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //后半部分逆序
        ListNode n1 = slow;
        ListNode n2 = slow.next;
        ListNode n3 = null;

        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        slow.next = null;

        //找到最后一个节点,和头节点
        ListNode t = n1;
        ListNode h = head;


        //判断是否回文
        while (h != null && t != h) {
            if (t.val != h.val) return false;
            t = t.next;
            h = h.next;
        }


        //最后需要在复原回去
        return true;
    }
}
