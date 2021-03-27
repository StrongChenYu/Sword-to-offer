package leetcode.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import structure.ListNode;

/**
 * @Author Chen Yu
 * @Date 2021/3/27 19:20
 */
public class P21_Merge_Two_Sorted_Lists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode head = res;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            res = res.next;
        }

        while (l1 != null) {
            res.next = new ListNode(l1.val);
            l1 = l1.next;
            res = res.next;
        }

        while (l2 != null) {
            res.next = new ListNode(l2.val);
            l2 = l2.next;
            res = res.next;
        }

        return head.next;
    }

    int[][] arrays1 = {
            {},
            {},
            {1,2,4},
    };

    int[][] arrays2 = {
            {1},
            {},
            {1,3,4,5,6,7},
    };

    int[][] wantRes = {
            {1},
            {},
            {1,1,2,3,4,4,5,6,7},
    };

    int testNum = arrays1.length;

    @Test
    public void Test() {

        for (int i = 0; i < testNum; i++) {
            /**
             * 测试是否能正确生成链表
             * 测试generateListFromArray
             * 和compareList两个函数是否正确
             */
            ListNode listNode1 = generateListFromArray(arrays1[i]);
            ListNode listNode2 = generateListFromArray(arrays2[i]);
            compareList(listNode1, listNode1);
            compareList(listNode2, listNode2);

            ListNode res = mergeTwoLists(listNode1, listNode2);
            compareList(res, generateListFromArray(wantRes[i]));
        }


    }

    public ListNode generateListFromArray(int[] array) {

        ListNode res = new ListNode(-1);
        ListNode head = res;
        for (int i = 0; i < array.length; i++) {
            res.next = new ListNode(array[i]);
            res = res.next;
        }

        return head.next;
    }

    public void compareList(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            Assert.assertEquals(l1.val, l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        Assert.assertNull(l1);
        Assert.assertNull(l2);
    }
}
