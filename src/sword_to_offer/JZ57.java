package sword_to_offer;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class JZ57 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;

        if (pNode.right != null) {
            //找那个最左边的然后返回
            TreeLinkNode res = pNode.right;
            while (res.left != null) res = res.left;
            return res;
        }

        TreeLinkNode parent = pNode.next;
        TreeLinkNode temp = pNode;
        if (parent != null) {
            //找到第一个左节点是该节点的部分
            while (parent != null && parent.left != temp) {
                temp = parent;
                parent = temp.next;
            }
            return parent;
        }

        return null;
    }
}
