package sort_algorithm;


public class MergeSort implements Sort{

    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        System.out.println("l = " + l + "r = " + r);;
        int middle = l + ((r - l) >> 1);
        mergeSort(arr, l ,middle);
        mergeSort(arr, middle, r);
        merge(arr, l, middle, r);
    }

    private void merge(int[] arr, int l, int middle, int r) {
        int[] temp = new int[r - l];

        int curL = l;
        int curR = middle;
        int i = 0;
        while (curL < middle && curR < r) {
            temp[i++] = arr[curL] > arr[curR] ? arr[curR++] : arr[curL++];
        }

        while (curL < middle) temp[i++] = arr[curL++];
        while (curR < r) temp[i++] = arr[curR++];

        for (int k = 0; k < temp.length; k++) {
            arr[l + k] = temp[k];
        }
    }


    public static void main(String[] args) {
        MergeSort m = new MergeSort();

        int[] array1 = new int[]{1,2,5,1,1,2};
        int[] array2 = new int[]{4,3,2,1,3};
        m.sort(array1);

        ArrayHelp.printArr(array1);
    }
}
