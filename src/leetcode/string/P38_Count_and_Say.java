package leetcode.string;

import org.junit.Test;

public class P38_Count_and_Say {

    public String countAndSay(int n) {
        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();

            // 遍历result
            int cnt = 0;
            char[] chars = result.toCharArray();

            for (int j = 0; j < chars.length; j++) {
                cnt++;

                if (j + 1 >= chars.length || chars[j] != chars[j + 1]) {
                    builder.append(cnt);
                    builder.append(chars[j]);

                    cnt = 0;
                }
            }

            result = builder.toString();
        }


        System.out.println(result);
        return result;
    }


    @Test
    public void test() {
        countAndSay(30);
    }
}
