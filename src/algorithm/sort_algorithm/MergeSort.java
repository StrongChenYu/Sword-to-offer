package algorithm.sort_algorithm;


public class MergeSort implements Sort{

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        mergeSort(arr, 0, arr.length);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (r - l <= 1) return;

        int middle = l + ((r - l) >> 1);
        mergeSort(arr, l, middle);
        mergeSort(arr, middle, r);
        merge(arr, l, middle, r);
    }

    private void merge(int[] arr, int l, int middle, int r) {
        int[] temp = new int[r - l];

        int left = l;
        int right = middle;
        int cur = 0;
        while (left < middle && right < r) temp[cur++] = arr[left] > arr[right] ? arr[right++] : arr[left++];

        while (left < middle) temp[cur++] = arr[left++];
        while (right < r) temp[cur++] = arr[right++];

        for (int i = 0; i < temp.length; i++) {
            arr[i + l] = temp[i];
        }
    }


    public static void main(String[] args) {
        MergeSort m = new MergeSort();

        int[] array = new int[]{600,5,1,3,1,2};

        m.sort(array);

        ArrayHelp.printArr(array);
    }
}
