package sword_to_offer;

import java.util.ArrayList;
import java.util.Arrays;

//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
public class JZ29 {

    //直接排序，完了返回，时间复杂度O(n*log(n))
    public ArrayList<Integer> GetLeastNumbers_Solution_QuickSort(int [] input, int k) {
        if (input == null || input.length == 0 || k > input.length) return new ArrayList<>();
        Arrays.sort(input);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k && i < input.length; i++) {
            res.add(input[i]);
        }
        return res;
    }

    /**
     * 用堆的思想解决，我自己实现堆
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0 || k > input.length) return new ArrayList<>();

        int n = input.length;
        //构建最小堆
        for (int i = 1; i < n; i++) {
            heapInsert(input, i);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(input[i]);
        }
        System.out.println();

        return null;
    }


    public void heapInsert(int[] input, int heapIndex) {
        int parentIndex = heapIndex / 2;
        while (parentIndex < heapIndex && input[parentIndex] > input[heapIndex]) {
            System.out.println(input[parentIndex]);
            swap(input, parentIndex, heapIndex);
            heapIndex = parentIndex;
            parentIndex = heapIndex >> 1;
        }
    }

    public void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        JZ29 jz29 = new JZ29();
        int[] a = new int[]{1,2,7,6,9,1};
        System.out.println(jz29.GetLeastNumbers_Solution(a, 4));
    }
}
