package sort_algorithm;


import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

public class SortTest {

    @Test
    public void Test() {
        Date date = new Date();
        System.out.println(date.toString());
    }

    @Test
    public void mergeSortTest() {
        int testTime = 10000;
        int maxSize = 10000;
        int maxValue = 100000;

        MergeSort m = new MergeSort();
        sortTest(m, testTime, maxSize, maxValue);
    }

    @Test
    public void quickSortTest() {
        int testTime = 10000;
        int maxSize = 10000;
        int maxValue = 100000;

        QuickSort m = new QuickSort();
        sortTest(m, testTime, maxSize, maxValue);
    }


    @Test
    public void heapSortTest() {
        int testTime = 10000;
        int maxSize = 10000;
        int maxValue = 100000;

        HeapSort m = new HeapSort();
        sortTest(m, testTime, maxSize, maxValue);
    }

    public void sortTest(Sort sort, int testTime, int maxSize, int maxValue) {


        for (int i = 0; i <testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arr1 = copyArray(arr);
            sort.sort(arr);
            absoluteCorrectSort(arr1);

            ArrayHelp.printArr(arr);
            ArrayHelp.printArr(arr1);


            Assert.assertArrayEquals(arr, arr1);

        }

    }



    private int[] copyArray(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    private void absoluteCorrectSort(int[] arr) {
        Arrays.sort(arr);
    }

    private int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxSize + 1) * Math.random());
        }
        return arr;
    }

}
