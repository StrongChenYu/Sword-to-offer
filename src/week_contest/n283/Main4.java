package week_contest.n283;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Main4 {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> res = new ArrayList<>();

        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }

        res.add(nums[0]);


        for (int right = 1; right < nums.length; right++) {
            int size = res.size();
            int leftNum = res.get(size - 1);
            int rightNum = nums[right];

            int maxCommon = maxCommonDivisor(leftNum, rightNum);

            if (maxCommon > 1) {
                int addNum = minCommonMultiple(leftNum, rightNum, maxCommon);

//                while (maxCommonDivisor(addNum, res.get(res.size() - 1)) > 1) {
//                    res.remove(res.size() - 1);
//                    res.add(minCommonMultiple(leftNum, rightNum, temp));
//                }
            } else {

                res.add(rightNum);
            }
        }


        return res;
    }

    private int maxCommonDivisor(int m, int n) {

        if (m < n) {// 保证m>n,若m<n,则进行数据交换
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {// 在余数不能为0时,进行循环
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;// 返回最大公约数
    }


    private int minCommonMultiple(long m, long n, long maxCommon) {
        return (int) (m * n / maxCommon);
    }

    @Test
    public void test() {
        replaceNonCoprimes(new int[]{287,41,49,287,899,23,23,20677,5,825});
    }
}
