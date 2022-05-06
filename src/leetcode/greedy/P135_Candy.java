package leetcode.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author Chen Yu
 * @Date 2021/4/24 20:29
 */
public class P135_Candy {

    public int candy(int[] ratings) {
        int[] cookies = new int[ratings.length];

        Arrays.fill(cookies, 1);
        for (int i = 0; i < ratings.length; i++) {
            int neighMaxCookies = 0;
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                neighMaxCookies = Math.max(neighMaxCookies, cookies[i - 1]);
            }

            if (i + 1 < ratings.length && ratings[i] > ratings[i + 1]) {
                neighMaxCookies = Math.max(neighMaxCookies, cookies[i + 1]);
            }

            if (neighMaxCookies != 0) {
                cookies[i] = neighMaxCookies + 1;
            }
        }

        for (int i = ratings.length - 1; i >= 0; i--) {
            int neighMaxCookies = 0;
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                neighMaxCookies = Math.max(neighMaxCookies, cookies[i - 1]);
            }

            if (i + 1 < ratings.length && ratings[i] > ratings[i + 1]) {
                neighMaxCookies = Math.max(neighMaxCookies, cookies[i + 1]);
            }

            if (neighMaxCookies != 0) {
                cookies[i] = neighMaxCookies + 1;
            }
        }


        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += cookies[i];
        }

        return sum;
    }

    @Test
    public void test() {
        candy(new int[]{1,3,4,5,2});
    }

}
