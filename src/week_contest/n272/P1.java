package week_contest.n272;

import org.junit.Test;

public class P1 {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isHuiWen(word)) {
                return word;
            }
        }
        return "";
    }

    public boolean isHuiWen(String word) {
        int l = 0;
        int r = word.length() - 1;

        while (l <= r) {
            if (word.charAt(l++) != word.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void Test() {
        System.out.println(isHuiWen("aba"));
        System.out.println(isHuiWen(""));
        System.out.println(isHuiWen("a"));
        System.out.println(isHuiWen("abbc"));
        System.out.println(isHuiWen("aaaaa"));
    }
}
