package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
public class JZ42 {

    /**
     * 双指针，一个指头一个指向尾部
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length <= 1) return res;

        int curHead = 0;
        int curTail = array.length - 1;

        while (curHead < curTail) {
            int tempSum = array[curHead] + array[curTail];

            if (tempSum == sum) {
                res.add(array[curHead]);
                res.add(array[curTail]);
                return res;
            } else if (tempSum > sum) curTail--;
            else  curHead++;
        }
        return res;
    }

    /**
     * hash法，O(n) 空间复杂度和时间复杂度
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum_Hash(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();

        if (array == null || array.length <= 1) return res;

        //res.add(0);res.add(0);
        HashMap<Integer, Integer> map = new HashMap<>();
        int minMultiply = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (map.containsKey(num)) {
                int n1 = map.get(num);
                int n2 = num;
                if (n1 * n2 < minMultiply) {
                    res.clear();
                    minMultiply = n1 * n2;
                    res.add(n1);
                    res.add(n2);
                }
            } else {
                map.put(sum - num, num);
            }
        }

        return res;
    }

    @Test
    public void Test() {
        JZ42 jz42 = new JZ42();
        int[] array = new int[]{1,2,4,7,11,15};

        ArrayList<Integer> res = jz42.FindNumbersWithSum(array, 15);
        Assert.assertEquals(res.get(0).intValue(), 4);
        Assert.assertEquals(res.get(1).intValue(),11);
    }

}
