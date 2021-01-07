package algorithm.numbertheory;

import org.junit.Assert;
import org.junit.Test;

public class isPrimeNumber{

    /**
     * base > 0
     * pawer > 0
     * @param base
     * @param power
     * @return
     */
    public int quickPower(int base, int power, int mod) {
        int res = 1;
        while (power > 0) {
            if ((power & 1) == 1) res = res * base % mod;
            power = power >> 1;
            base = base * base % mod;
        }
        return res;
    }


    public boolean isPrime(int n) {
        int[] numberSet = new int[]{2,3,5,7,11};

        int count = 0;
        for (int i = 0; i < numberSet.length; i++) {
            int a = numberSet[i];
            if (quickPower(a, n - 1, n) == 1)
                count++;
        }

        if (count == numberSet.length) return true;
        else return false;
    }

    @Test
    public void Test() {
        Assert.assertTrue(isPrime(13));
        Assert.assertFalse(isPrime(15));
        Assert.assertTrue(isPrime(101));
    }
}
