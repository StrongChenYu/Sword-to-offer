package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * 不使用加减乘除做加法
 */
public class JZ48 {

    public int Add(int num1,int num2) {
        int sum = 0;
        int carry = 0;

        /**
         * num1 ^ num2 是没有进位后的结果
         * (num2 & num2) << 1 是进位
         * 两个加到没有进位为止
         */
        do {
            sum = num1 ^ num2;
            carry = ((num1 & num2) << 1);

            num1 = sum;
            num2 = carry;
        } while (carry != 0);

        return num1;
    }


    @Test
    public void Test() {
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                Assert.assertEquals(i + j, Add(i,j));
            }
        }
    }


    public static void main(String[] args) {
        int a = 5 ^ 17;
        int b = ((5 & 17) << 1);
        System.out.println(a | b);
    }
}
