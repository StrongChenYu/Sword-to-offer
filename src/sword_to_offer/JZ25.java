package sword_to_offer;

import structure.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class JZ25 {


    //深拷贝randomnode list，左神课上所讲
    //两种方法1.借用map
    //2.放置一个虚拟节点
    public RandomListNode Clone1(RandomListNode pHead){
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();

        //第一次先把所有的节点放进去
        RandomListNode head = pHead;
        while (head != null) {
            nodeMap.put(head, new RandomListNode(head.label));
            head = head.next;
        }

        //第二次开始读取
        head = pHead;
        //假节点
        RandomListNode res = new RandomListNode(0);
        RandomListNode resCopy = res;
        while (head != null) {
            res.next =  nodeMap.get(head);
            res.next.random = nodeMap.get(head.random);

            head = head.next;
            res = res.next;
        }

        return resCopy.next;
    }


    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null) return null;

        RandomListNode head = pHead;

        while (head != null) {
            RandomListNode copyNode = new RandomListNode(head.label);
            copyNode.next = head.next;
            head.next = copyNode;
            head = copyNode.next;
        }

        head = pHead;
        while (head != null) {
            if (head.random != null) head.next.random = head.random.next;
            head = head.next.next;
        }

        head = pHead;
        RandomListNode res = pHead.next;
        RandomListNode tempNode;
        while (head != null) {
            tempNode = head.next;
            head.next = tempNode.next;

            if (tempNode.next != null) {
                tempNode.next = tempNode.next.next;
            }

            head = head.next;
        }

        return res;
    }

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(1);
        node.next = new RandomListNode(2);

        node.next.next = new RandomListNode(3);
        node.next.next.next = new RandomListNode(4);
        node.next.next.next.next = new RandomListNode(5);

        node.random = node.next.next.next;

        JZ25 jz25 = new JZ25();

        jz25.Clone(node);
    }
}
