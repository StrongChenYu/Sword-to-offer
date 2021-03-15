package structure;

public class ListNode {
   public int val;
   public ListNode next = null;

   public ListNode(int val) {
        this.val = val;
   }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
