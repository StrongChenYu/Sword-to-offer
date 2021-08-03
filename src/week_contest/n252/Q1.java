package week_contest.n252;

import org.junit.Test;

public class Q1 {

    public boolean isThree(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
            }
            if (cnt > 3) {
                return false;
            }
        }
        return cnt == 3;
    }

    @Test
    public void Test() {
        System.out.println(isThree(1));
        System.out.println(isThree(2));
        System.out.println(isThree(3));
        System.out.println(isThree(4));
        System.out.println(isThree(25));
    }
}
