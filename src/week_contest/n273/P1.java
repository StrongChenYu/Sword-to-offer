package week_contest.n273;

import org.junit.Test;

public class P1 {

    public boolean isSameAfterReversals(int num) {
        if (num == 0) return true;
        return !(num % 10 == 0);
    }

    @Test
    public void Test() {
        System.out.println(isSameAfterReversals(526));
        System.out.println(isSameAfterReversals(1800));
        System.out.println(isSameAfterReversals(0));
    }
}
