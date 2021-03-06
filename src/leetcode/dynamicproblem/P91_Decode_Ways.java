package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Chen Yu
 * @Date 2021/3/28 20:29
 */
public class P91_Decode_Ways {

    /**
     * 解码
     * @param s
     * @return
     */
    private Map<String, Integer> map = new HashMap<>();
    public int numDecodings_Recursion(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        if (map.containsKey(s)) return map.get(s);
        /**
         * 字符串长度大于等于2的情况
         * 字符串首字母不为0
         */
        int n = s.length();

        //先是处理1长度
        int caseOne = numDecodings_Recursion(s.substring(1, n));

        //接着处理2长度
        int num = Integer.parseInt(s.substring(0, 2));
        int caseTwo = 0;
        if (10 <= num && num <= 26) {
            caseTwo = n == 2 ? 1 : numDecodings_Recursion(s.substring(2, n));
        }

        int res = caseOne + caseTwo;
        map.put(s, res);
        return res;
    }

    @Test
    public void Test() {
        Assert.assertEquals(numDecodings("12"), 2);
        Assert.assertEquals(numDecodings("226"), 3);
        Assert.assertEquals(numDecodings("0"), 0);
        Assert.assertEquals(numDecodings("06"), 0);
        Assert.assertEquals(numDecodings("606"), 0);

        /**
         * 拿一个绝对正确的方法验证
         */
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String sInput = i + "";
            System.out.println(sInput);
            Assert.assertEquals(numDecodings(sInput), numDecodings_Recursion(sInput));
        }
    }

    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        int a1 = 1;
        int a2 = 1;
        int a3 = 0;
        /**
         * 表示长度为i的字符串的划分方案个数
         */
        for (int i = 2; i <= s.length(); i++) {
            a3 = 0;
            /**
             * 要判断是不是0
             */
            if (s.charAt(i - 1) != '0') a3 += a2;

            /**
             * 判断s[i - 2] - s[i]字符串是否为合法的
             */
            int beforeTwo = Integer.parseInt(s.substring(i - 2,i));
            if (beforeTwo <= 26 && beforeTwo >= 10) {
                a3 += a1;
            }

            a1 = a2;
            a2 = a3;
        }

        return a3;
    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println(s.substring(2, s.length()));
    }
}
