package sort_algorithm;

import java.lang.reflect.Array;

public class HeapSort implements Sort{

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    public void heapInsert(int[] arr, int index) {
        //index > 0 的条件可以省略，因为如果index是1的话，两个值必定相等，无法进入循环
        while (arr[(index - 1) / 2] < arr[index]) {
            int fa = (index - 1) / 2;
            swap(arr, index, fa);
            index = fa;
        }
    }

    public void heapify(int[]arr, int index, int heapSize) {
        int left = index * 2 + 1;

        while (left < heapSize) {
            int right = left + 1;
            int maxLeftRightIndex = right < heapSize && arr[left] < arr[right] ? right : left;

            int maxIndex = arr[maxLeftRightIndex] > arr[index] ? maxLeftRightIndex : index;

            if (maxIndex == index) {
                break;
            }

            swap(arr, index, maxIndex);
            index = maxIndex;
            left = maxIndex * 2 + 1;
        }

    }


    public void swap(int []arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort h = new HeapSort();
        int[] a = new int[]{1,2,3,4,1,3,14,1,414,1,41,41,41,1};
        h.sort(a);
        ArrayHelp.printArr(a);
    }
}
