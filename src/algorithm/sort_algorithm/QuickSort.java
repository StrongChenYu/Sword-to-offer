package algorithm.sort_algorithm;

public class QuickSort implements Sort{

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int index = l + ((r - l) >> 1);
        int[] bound = partition(arr, index, l, r);

        quickSort(arr, l, bound[0]);
        quickSort(arr, bound[1], r);
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

    public void swap(int []arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,3,4,3,1,4,1,1,23,4,5,4,2,2,3,5,3,1,1,2,3,4,5,6,7};
        QuickSort q = new QuickSort();

        q.sort(arr);
        printArray(arr);
    }

}

