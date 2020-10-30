package sword_to_offer;


//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
public class JZ23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return helpFunc(sequence, 0, sequence.length - 1);
    }

    public boolean helpFunc(int[] sequence, int start, int end) {
        //只有一个为true
        if (start >= end) return true;

        int root = sequence[end];
        int separate = start;
        //获取root，可以将数组分为两部分，为true
        for (; separate <= end - 1 && sequence[separate] < root; separate++);

        //这步运行完了之后，就会到达第一个最大的节点
        for (int i = separate + 1; i <= end - 1; i++) {
            if (sequence[i] < root) return false;
        }

        //左部分为true
        //右部分为true
        return helpFunc(sequence, start, separate - 1) && helpFunc(sequence, separate, end - 1);
    }

    public static void main(String[] args) {
        int[] res = new int[] {3,4,5,7,1,10,6};

        JZ23 jz23 = new JZ23();
        System.out.println(jz23.VerifySquenceOfBST(res));
    }
}
