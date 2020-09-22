package sort_algorithm;


public class MergeSort implements Sort{

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int mid = l + ((r - l) >> 1);

        //注意递归是i
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public void merge(int[] arr, int l, int mid, int r) {
        int[] newArr = new int[r - l + 1];

        int left = l;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= r) {
            if (arr[left] > arr[right]) {
                newArr[index++] = arr[right++];
            } else {
                newArr[index++] = arr[left++];
            }
        }

        while (left <= mid) {
            newArr[index++] = arr[left++];
        }

        while (right <= r) {
            newArr[index++] = arr[right++];
        }

        for (int i = 0; i < newArr.length; i++) {
            arr[i + l] = newArr[i];
        }
    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort();

        int[] array = new int[]{600,5,1,3,1,2};

        m.sort(array);

        System.out.println(array);
    }
}
