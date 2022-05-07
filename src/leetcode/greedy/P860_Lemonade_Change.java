package leetcode.greedy;

import org.junit.Test;

public class P860_Lemonade_Change {

    public boolean lemonadeChange(int[] bills) {
        int cnt5 = 0;
        int cnt10 = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                cnt5++;
            } else if (bills[i] == 10) {
                if (cnt5 == 0) {
                    // 说明没有零钱可以找了
                    return false;
                }

                cnt5--;
                cnt10++;
            } else {
                // 20块钱
                // 先这样1张5 1张10
                if (cnt5 > 0) {
                    if (cnt10 >= 1) {
                        // cnt5 == 1 并且 cnt10 == 0
                        cnt10--;
                        cnt5--;
                    } else if (cnt5 >= 3) {
                        cnt5 -= 3;
                    } else {
                        return false;
                    }

                } else {
                    return false;
                }

                // 3张5
            }
        }

        return true;
    }

    @Test
    public void test() {
        System.out.println(lemonadeChange(new int[]{5,5,5,5,5,5,5,20,20,20}));
    }
}
