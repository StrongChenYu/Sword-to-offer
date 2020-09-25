package sword_to_offer;

import java.util.Stack;

public class JZ14 {
    //这里有两个边界条件
    //1.假如k为0的边界条件，如果链表不为空，但是k为0
    //2.k的值大于实际存在的node个数，应该返回null
    public ListNode FindKthToTail(ListNode head,int k) {
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
}
