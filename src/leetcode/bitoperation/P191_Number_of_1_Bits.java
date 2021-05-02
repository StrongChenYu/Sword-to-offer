package leetcode.bitoperation;

/**
 * @Author Chen Yu
 * @Date 2021/5/2 20:44
 */
public class P191_Number_of_1_Bits {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
