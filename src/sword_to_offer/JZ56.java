package sword_to_offer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import structure.ListNode;

public class JZ56 {

    private int[][] testData = {
            {1,2,3,3,4,4,5},
            {1,2,2,3},
            {1,1,1,1,2},
            {1,1,1,1,1,1}
    };

    private int[][] wanted = {
            {1,2,5},
            {1,3},
            {2},
            {}
    };


    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;

        ListNode head = new ListNode(0);
        head.next = pHead;

        ListNode pre = head;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }

                cur = cur.next;
                pre.next = cur;

            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }





    private ListNode transformToList(int[] arrays) {
        ListNode list = new ListNode(0);
        ListNode head = list;
        for (int i = 0; i < arrays.length; i++) {
            list.next = new ListNode(arrays[i]);
            list = list.next;
        }
        return head.next;
    }

    @Test
    public void Test() {
        for (int i = 0; i < testData.length; i++) {
            ListNode listNode = transformToList(testData[i]);
            ListNode result = deleteDuplication(listNode);
            ListNode wantedData = transformToList(wanted[i]);
            ifToListNodeEqual(result, wantedData);
        }
    }

    private void ifToListNodeEqual(ListNode result, ListNode wantedData) {
        while (result != null && wantedData != null) {
            Assert.assertEquals(result.val, wantedData.val);
            result = result.next;
            wantedData = wantedData.next;
        }
        Assert.assertNull(result);
        Assert.assertNull(wantedData);
    }
}
