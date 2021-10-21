package leetcode.math;

import org.junit.Test;

public class P233_Number_of_Digit_One {

    public int countDigitOne(int n) {
        int cnt = 0;
        int rightValue = 0;
        int plus = 1;
        while (n != 0) {
            int curValue = n % 10;
            int leftValue = n / 10;

            if (curValue < 1) {
                cnt += (leftValue * plus);
            } else if (curValue == 1) {
                cnt += (leftValue * plus + rightValue + 1);
            } else {
                cnt += ((leftValue + 1) * plus);
            }

            rightValue = rightValue + (n % 10) * plus;
            plus = 10 * plus;
            n = n / 10;
        }
        return cnt;
    }

    @Test
    public void Test() {
        System.out.println(countDigitOne(0));
    }

    public static void main(String[] args) {

    }
}
