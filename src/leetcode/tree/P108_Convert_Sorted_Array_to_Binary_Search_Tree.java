package leetcode.tree;

import org.junit.Test;
import structure.TreeNode;

/**
 * @Author Chen Yu
 * @Date 2021/5/5 8:28
 */
public class P108_Convert_Sorted_Array_to_Binary_Search_Tree {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode BST = toBST(nums, 0, nums.length);
        return BST;
    }

    /**
     * [left, right)
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public TreeNode toBST(int[] nums, int left, int right) {
        if (left >= right) return null;

        int middle = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[middle]);

        root.left = toBST(nums, left, middle);
        root.right = toBST(nums, middle + 1, right);

        return root;
    }

    @Test
    public void Test() {
        sortedArrayToBST(new int[]{1,2,3});
    }

    public static void main(String[] args) {
        int left = 0;
        int right = 1;
        int middle = left + ((right - left) >> 1);
        System.out.println(middle);
    }
}
