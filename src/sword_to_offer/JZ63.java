package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JZ63 {

    ArrayList<Integer> mem = new ArrayList<>();

    public void Insert(Integer num) {
        int low = lowerBound(num);
        mem.add(low, num);
    }

    private int lowerBound(int num) {
        int l = 0;
        int r = mem.size();

        while (l < r) {
            int middle = l + ((r - l) >> 1);
            if (mem.get(middle) < num) {
                l = middle + 1;
            } else {
                r = middle;
            }
        }
        return l;
    }


    @Test
    public void lowerBoundTest() {
//        Integer[] array = new Integer[] {1,3,4,4,4,4,4,5};
//        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(array));
//
//        System.out.println(lowerBound(nums, 2));

        JZ63 jz63 = new JZ63();
        jz63.Insert(1);
        jz63.Insert(1);
        jz63.Insert(1);
        jz63.Insert(1);
        jz63.Insert(1);

    }

    public Double GetMedian() {
        int size = mem.size();
        if (size == 0) return null;

        int middle = (size >> 1);
        if ((size & 1) == 0) {
            //偶数
            int num1 = mem.get(middle);
            int num2 = mem.get(middle - 1);

            return ((double) (num1 + num2)) / 2;
        } else {
            //奇数
            return Double.valueOf(mem.get(middle));
        }
    }

    @Test
    public void getMedianTest() {
        int[] array1 = new int[] {1,2,3};
        testTemplate(array1, 2);

        int[] array2 = new int[] {1,2,3,4};
        testTemplate(array2, 2.5);

        int[] array3 = new int[] {1};
        testTemplate(array3, 1);

        int[] array4 = new int[] {1,2};
        testTemplate(array4, 1.5);

        int[] array5 = new int[100];
        for (int i = 0; i < 100; i++) {
            array5[i] = i + 1;
        }
        testTemplate(array5, 50.5);


        int[] array6 = new int[101];
        for (int i = 0; i < 101; i++) {
            array6[i] = i + 1;
        }
        testTemplate(array6, 51);
    }

    public void testTemplate(int[] array, double expected) {
        JZ63 jz63 = new JZ63();
        for (int a : array) {
            jz63.Insert(a);
        }
        Assert.assertEquals(Double.valueOf(expected), jz63.GetMedian());
    }

}
