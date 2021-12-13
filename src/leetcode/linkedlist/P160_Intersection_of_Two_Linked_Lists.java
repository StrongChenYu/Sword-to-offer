package leetcode.linkedlist;

import structure.ListNode;

public class P160_Intersection_of_Two_Linked_Lists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pHeadA = headA;
        ListNode pHeadB = headB;
        while (headA != headB) {
            headA = headA == null ? pHeadB : headA.next;
            headB = headB == null ? pHeadA : headB.next;
        }
        return headA;
    }
}
