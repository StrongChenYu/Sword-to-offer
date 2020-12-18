package sort_algorithm;

import java.lang.reflect.Array;

public class HeapSort implements Sort{

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        for (int i = 1; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
    }

    private void heapInsert(int[] arr, int insertIndex) {
        int parentIndex = (insertIndex - 1) / 2 ;
        while (arr[parentIndex] < arr[insertIndex]) {
            swap(arr, parentIndex, insertIndex);
            insertIndex = parentIndex;
            parentIndex = (insertIndex - 1) / 2;
        }
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int right = left + 1;
            int maxLR = left;
            if (right < heapSize) {
                maxLR = arr[left] < arr[right] ? right : left;
            }

            int maxIndex = arr[index] < arr[maxLR] ? maxLR : index;
            if (maxIndex == index) return;

            swap(arr, index, maxLR);
            index = maxLR;
            left = index * 2 + 1;
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
