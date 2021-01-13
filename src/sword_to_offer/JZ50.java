package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JZ50 {

    /**
     * o(n) 时间复杂度
     * o(n) 空间复杂度
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate_bk(int numbers[],int length,int [] duplication) {
        Map<Integer, Boolean> record = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int num = numbers[i];
            if (record.containsKey(num)) {
                record.put(num, true);
            } else {
                record.put(num, false);
            }
        }

        for (int i = 0; i < length; i++) {
            if (record.get(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
        }

        return false;
    }


    /**
     * in-place算法
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length <= 0) return false;

        int cur = 0;
        while (cur < length) {
            if (cur == numbers[cur]) {
                cur++;
                continue;
            }
            //numbers[cur]表示当前的值
            //number[number[cur]]表示当前的值应该去的地方
            if (numbers[cur] == numbers[numbers[cur]]) {
                duplication[0] = numbers[cur];
                return true;
            }
            swap(numbers, cur, numbers[cur]);
        }

        return false;
    }

    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    @Test
    public void Test() {
        int[] duplication = new int[1];
        Assert.assertTrue(duplicate(new int[]{1,1}, 2, duplication));
        Assert.assertEquals(1, duplication[0]);

        Assert.assertFalse(duplicate(new int[]{1,2,3}, 3, duplication));

        Assert.assertTrue(duplicate(new int[]{2,3,1,0,2,5,3}, 7, duplication));
        Assert.assertEquals(2, duplication[0]);

        Assert.assertFalse(duplicate(new int[]{1}, 1, duplication));

        Assert.assertTrue(duplicate(new int[]{1,2,3,1,2,3}, 6, duplication));
        Assert.assertEquals(1, duplication[0]);

        //Assert.assertTrue(duplicate(new int[]{1,2,2,1}, 4, duplication));
        //Assert.assertEquals(1, duplication[0]);
    }
}
