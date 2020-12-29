package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

public class JZ35 {

    private int res = 0;
    public int InversePairs(int [] array) {
        mergeSort(array, 0, array.length);
        return res % 1000000007;
    }



    public void mergeSort(int[] arr, int l, int r) {
        if (r - l == 1) return;

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
            if (arr[curL] > arr[curR]) {
                res = (res + (middle - curL)) % 1000000007;
                temp[i++] = arr[curR++];
            } else {
                temp[i++] = arr[curL++];
            }
        }

        while (curL < middle) {
            temp[i++] = arr[curL++];
        }
        while (curR < r) {
            temp[i++] = arr[curR++];
        }

        for (int k = 0; k < temp.length; k++) {
            arr[l + k] = temp[k];
        }
    }

    @Test
    public void Test() {
        int[] array = new int[]{1,2,3,4,5,6,7,1};

        Assert.assertEquals(InversePairs(array),6);
    }
}
