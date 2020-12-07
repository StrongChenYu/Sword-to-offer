package sort_algorithm;

public class QuickSort implements Sort{

    @Override
    public void sort(int[] arr) {

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,3,4,3,1,4,1,1,23,4,5,4,2,2,3,5,3,1,1,2,3,4,5,6,7};
        QuickSort q = new QuickSort();

        q.sort(arr);
    }



}

