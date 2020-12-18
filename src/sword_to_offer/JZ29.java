package sword_to_offer;


import java.util.ArrayList;

public class JZ29 {

    //快排思想解决
    //这似乎就是TOPK算法
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0 || k > input.length) return new ArrayList<>();
        return RecursionHelp(input, 0, input.length, k);
    }

    public ArrayList<Integer> RecursionHelp(int[] input, int l, int r, int k) {
        int index = l + ((r - l) >> 1);
        int leftBound = partition(input, index, l, r)[0];

        System.out.println("l = " + l + "r = " + r + " k = " + k + " leftBoud = " + leftBound);


        ArrayList<Integer> res = new ArrayList<>();

        if (l >= r) return res;

        int leftNum = leftBound - l;
        if (leftNum > k) {
            System.out.println("1");
            return RecursionHelp(input, l, leftBound, k);
        } else if (leftNum == k) {
            System.out.println("2");
            for (int i = l; i < leftBound; i++) res.add(input[i]);
        } else {
            System.out.println("3");
            for (int i = l; i < leftBound; i++) res.add(input[i]);
            ArrayList<Integer> rightRes = RecursionHelp(input, leftBound, r, k - leftNum);
            res.addAll(rightRes);
        }

        return res;
    }

    public int[] partition(int[] arr, int index, int l, int r) {
        int targetNum = arr[index];
        int left = l - 1;
        int right = r;
        int cur = l;

        while (cur < right) {
            if (targetNum == arr[cur]) {
                cur++;
            } else if (targetNum > arr[cur]) {
                swap(arr, ++left, cur++);
            } else {
                swap(arr, --right, cur);
            }
        }

        return new int[]{left + 1, right};
    }

    //范围l<= x <r
//    public int partition(int[] input, int l, int r) {
//
//        int index  = r - 1;
//        int targetNum = input[index];
//
//        int left = l - 1;
//        for (int cur = l; cur < r; cur++) {
//            if (input[cur] < targetNum) {
//                swap(input, ++left, cur);
//            }
//        }
//
//        //这里记得最后把index位置的值换回去
//        swap(input, ++left, index);
//        return left;
//    }

    //用堆对思想解决
    public ArrayList<Integer> GetLeastNumbers_Solution_Heap(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k) return res;

        for (int i = 1; i < input.length; i++) {
            heapInsert(input, i);
        }

        int headIndex = input.length - 1;
        for (int i = 0; i < k; i++) {
            res.add(heapDelete(input, headIndex--));
        }
        return res;
    }

    public int heapDelete(int[] input, int headIndex) {
        int res = input[0];
        swap(input, 0, headIndex--);

        int index = 0;
        int left = (index << 1) + 1;
        int right = left + 1;
        while (left <= headIndex && (input[index] > input[left] || input[index] > input[right])) {
            int swapIndex = 0;

            if (left <= headIndex && right <= headIndex) {
                swapIndex = input[left] < input[right] ? left : right;
            } else if (left > headIndex) {
                swapIndex = right;
            } else {
                swapIndex = left;
            }

            swap(input, index, swapIndex);

            index = swapIndex;
            left = (index << 1) + 1;
            right = left + 2;
        }

        return res;
    }

    /**
     * 这是比较好的做法因为，上面的比较累两次left，index，right之间的情况，但是下面这种方法的话，只比较累一次
     * @param input
     * @param insertIndex
     */
//    public void heapify(int[]arr, int index, int heapSize) {
//        int left = index * 2 + 1;
//
//        while (left < heapSize) {
//            int right = left + 1;
//            int maxLeftRightIndex = right < heapSize && arr[left] < arr[right] ? right : left;
//
//            int maxIndex = arr[maxLeftRightIndex] > arr[index] ? maxLeftRightIndex : index;
//
//            if (maxIndex == index) {
//                break;
//            }
//
//            swap(arr, index, maxIndex);
//            index = maxIndex;
//            left = maxIndex * 2 + 1;
//        }
//
//    }


    private void heapInsert(int[] input, int insertIndex) {
        int parentIndex = insertIndex >> 1;
        while (parentIndex < insertIndex && input[parentIndex] > input[insertIndex]) {
            swap(input, parentIndex, insertIndex);
            insertIndex = parentIndex;
            parentIndex = insertIndex >> 1;
        }
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void pringArray(int[] a) {
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        JZ29 jz29 = new JZ29();
        int[] a = new int[]{0,0,1,3,4,5,0,7,6,7};
        System.out.println(jz29.GetLeastNumbers_Solution(a, 9));
        pringArray(a);
    }
}
