package sword_to_offer;

import structure.TreeNode;

import java.util.ArrayList;

public class JZ24 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null || target < 0) return new ArrayList<>();

        int val = root.val;
        //this step can be ignored
        //if (val > target) return null;

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (val == target) {
            if (root.left == null && root.right == null) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(val);
                res.add(temp);
            }
        } else {
            ArrayList<ArrayList<Integer>> lefts = FindPath(root.left, target - val);
            ArrayList<ArrayList<Integer>> rights = FindPath(root.right, target - val);

            for (ArrayList<Integer> list : lefts) {
                list.add(0,val);
                res.add(list);
            }

            for (ArrayList<Integer> list : rights) {
                list.add(0,val);
                res.add(list);
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        ArrayList<Integer> test = new ArrayList<>();
//
//        test.add(1);
//        test.add(2);
//
//        test.add(0,0);
//
//        for (Integer i : test) {
//            System.out.println(i);
//        }

        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);


        JZ24 jz24 = new JZ24();
        ArrayList<ArrayList<Integer>> res = jz24.FindPath(root1,9);

        System.out.println(res);
    }
}
