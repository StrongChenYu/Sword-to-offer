package leetcode.sort;

import org.junit.Before;
import org.junit.Test;
import structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Chen Yu
 * @Date 2021/4/27 8:48
 */
public class P148_Sort_List {

    /**
     * 归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
         if (head == null || head.next == null) {
             return head;
         }

         ListNode fast = head.next;
         ListNode slow = head;

         while (fast != null && fast.next != null) {
             /**
              * 快指针一次两步
              * 慢指针一次一步
              */
             fast = fast.next.next;
             slow = slow.next;
         }

         ListNode leftList = head;
         ListNode rightList = slow.next;

         slow.next = null;

        ListNode sortL = sortList(leftList);
        ListNode sortR = sortList(rightList);

        /**
         * 合并链表
         */
        ListNode res = new ListNode(Integer.MIN_VALUE);

        ListNode h = res;
        while (sortL != null && sortR != null) {
            if (sortL.val < sortR.val) {
                h.next = sortL;
                sortL = sortL.next;
            } else {
                h.next = sortR;
                sortR = sortR.next;
            }
            h = h.next;
        }
        h.next = sortL != null ? sortL : sortR;

        return res.next;
    }



    private ListNode data = null;

    @Before
    public void before() {
        data = new ListNode(5);
        data.next = new ListNode(5);
        data.next.next = new ListNode(2);
        //data.next.next.next = new ListNode(5);
    }

    @Test
    public void Test() {
        ListNode listNode = sortList(data);
        System.out.println("chen");
    }
}
