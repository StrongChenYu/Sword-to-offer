package sort_algorithm;

public class QuickSort implements Sort{

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int length = arr.length;
        quickSort(arr, 0, length - 1);
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l >= r || l < 0) return;

        int[] mids = partition(arr, l, r);
        quickSort(arr, l, mids[0]);
        quickSort(arr, mids[1], r);
    }

    public int[] partition(int arr[], int l, int r) {
        int[] mids = new int[]{l ,r};
        int num = arr[r];

        int left = l - 1;
        int right = r;
        int cur = l;

        while (cur < right) {
            if (arr[cur] < num) {
                swap(arr, ++left, cur++);
            } else if (arr[cur] > num) {
                swap(arr, --right, cur);
            } else {
                cur++;
            }
        }

        swap(arr, right++, r);

        mids[0] = left;
        mids[1] = right;
        return mids;
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

