package week_contest.n272;

import org.junit.Test;

public class P3 {

    public long getDescentPeriods(int[] prices) {
        int l = 0;
        int r = 0;
        long cnt = 0;

        while (l < prices.length && r < prices.length) {
            if (r + 1 < prices.length) {
                if (prices[r] - prices[r + 1] == 1) {
                    r++;
                } else {
                    long n = (r - l + 1);
                    cnt += n * (n + 1) / 2;

                    r++;
                    l = r;
                }
            } else {
                long n = (r - l + 1);
                cnt += n * (n + 1) / 2;

                r++;
                l = r;
            }
        }
        return cnt;
    }

    @Test
    public void Test() {
        System.out.println(getDescentPeriods(new int[]{3,2,1,4,2,1}));
    }
}
