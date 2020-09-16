import java.util.ArrayList;
import java.util.List;
//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
public class JZ3 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> nodes = new ArrayList<Integer>();

        if (listNode == null) return nodes;

        if (listNode.next == null) {
            nodes.add(listNode.val);
            return nodes;
        }

        nodes.addAll(printListFromTailToHead(listNode.next));
        nodes.add(listNode.val);

        return nodes;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println(printListFromTailToHead(head));
    }
}
