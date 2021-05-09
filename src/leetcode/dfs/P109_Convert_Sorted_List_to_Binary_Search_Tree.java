package leetcode.dfs;

import org.junit.Before;
import org.junit.Test;
import structure.ListNode;
import structure.TreeNode;

public class P109_Convert_Sorted_List_to_Binary_Search_Tree {

    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = toBST(head, null);
        return root;
    }

    /**
     * [head, tail)
     * @param head
     * @param tail
     * @return
     */
    public TreeNode toBST(ListNode head, ListNode tail) {
        if (head == null || head == tail) return null;
        if (head.next == tail) return new TreeNode(head.val);

        /**
         * 快慢指针找中点
         */
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        /**
         * 以slow指针为中点进行分割
         */
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);

        return root;
    }

    private ListNode test;
    @Before
    public void before() {
        test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(3);
        test.next.next.next.next = new ListNode(3);
        test.next.next.next.next.next = new ListNode(3);
        test.next.next.next.next.next.next = new ListNode(3);
    }

    @Test
    public void Test() {
        sortedListToBST(test);
    }
}
