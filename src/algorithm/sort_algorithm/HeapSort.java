package algorithm.sort_algorithm;

public class HeapSort implements Sort{

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        for (int i = 1; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapAdjust(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * wrong case:
     * 0,1,2
     * 2 / 2 = 1;
     * 1 / 2 = 0;
     *
     * right case:
     * 0,1,2
     * (2-1) / 2 = 0;
     * (1-1) / 2 = 0;
     *
     * so: parent = (insertIndex - 1) / 2;
     * @param arr
     * @param insertIndex
     */
    private void heapInsert(int[] arr, int insertIndex) {
        int parent = (insertIndex - 1) / 2;
        while (arr[insertIndex] > arr[parent]) {
            swap(arr, insertIndex, parent);
            insertIndex = parent;
            parent = (insertIndex - 1) / 2;
        }
    }

    private void heapAdjust(int[] arr, int cur, int heapSize) {
        int leftIndex = (cur << 1) + 1;
        int rightIndex = 0;
        int maxIndex = 0;
        while (leftIndex < heapSize) {
            rightIndex = leftIndex + 1;
            if (rightIndex < heapSize) maxIndex = arr[leftIndex] >= arr[rightIndex] ? leftIndex : rightIndex;
            else maxIndex = leftIndex;

            if (arr[maxIndex] <= arr[cur]) break;

            swap(arr, maxIndex, cur);

            cur = maxIndex;
            leftIndex = (cur << 1) + 1;
        }
    }

    public void swap(int []arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort h = new HeapSort();
        int[] a = new int[]{1,5,6,7,89,6,4,7,8,5,6,9,6,9,6,9,6};
        h.sort(a);
        ArrayHelp.printArr(a);
    }
}
