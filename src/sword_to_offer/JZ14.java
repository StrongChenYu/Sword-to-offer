package sword_to_offer;

import structure.ListNode;

import java.util.Stack;


/**
 *
 输入一个链表，输出该链表中倒数第k个结点。
 */
public class JZ14 {
    //这里有两个边界条件
    //1.假如k为0的边界条件，如果链表不为空，但是k为0
    //2.k的值大于实际存在的node个数，应该返回null
    public ListNode FindKthToTailSlow(ListNode head, int k) {
        if (head == null || k == 0) return null;

        Stack<ListNode> stack = new Stack<>();
        ListNode hp = head;
        while (hp != null) {
            stack.push(hp);
            hp = hp.next;
        }

        int i  = 0;
        while (!stack.isEmpty() && i < k - 1) {
            stack.pop();
            i++;
        }

        if (stack.isEmpty()) return null;
        return stack.pop();
    }

    /**
     * 上面做法空间复杂度和时间复杂度都不如双指针。
     */

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) return null;

        ListNode l = head;
        ListNode r = head;
        for (int i = 0; i < k - 1; i++) {
            if (r.next != null) {
                r = r.next;
            }
            else{
                return null;
            }
        }

        while (r.next != null) {
            r = r.next;
            l = l.next;
        }

        return l;
    }
}
