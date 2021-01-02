package sword_to_offer;

import structure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class JZ36 {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode_MemSolution(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> nodeSet = new HashSet<>();

        while (pHead1 != null) {
            nodeSet.add(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            if (nodeSet.contains(pHead2)) return pHead2;
            pHead2 = pHead2.next;
        }

        return null;
    }

    /**
     * 这个算法更牛逼
     * 但是如果链表很长的话，两个链表都很长的话，时间上的开销可能更大一点
     * s
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode temp1 = pHead1, temp2 = pHead2;
        while (temp1 != temp2) {
            temp1 = temp1 != null ? temp1.next : pHead2;
            temp2 = temp2 != null ? temp2.next : pHead1;
        }
        return temp1;
    }
}
