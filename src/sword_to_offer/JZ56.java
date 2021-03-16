package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;
import structure.ListNode;

public class JZ56 {

    private int[][] testData = {
            {1,2,3,3,4,4,5},
            {1,2,2,3},
            {1,1,1,1,2},
            {1,1,1,1,1,1},
            {1,2,2,2,2,2}
    };

    private int[][] wanted = {
            {1,2,5},
            {1,3},
            {2},
            {},
            {1}
    };


    public ListNode deleteDuplication(ListNode pHead) {

        ListNode head = new ListNode(0);
        head.next = pHead;

        ListNode pre = head;
        while (pHead != null) {
            if (pHead.next != null && pHead.next.val == pHead.val) {
                while (pHead.next != null && pHead.next.val == pHead.val) {
                    pHead = pHead.next;
                }
                pre.next = pHead.next;
            } else {
                pre = pHead;
            }
            pHead = pHead.next;
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
        for (int i = 3; i < 4; i++) {
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
