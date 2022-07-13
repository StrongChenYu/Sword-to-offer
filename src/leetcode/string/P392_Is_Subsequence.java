package leetcode.string;

public class P392_Is_Subsequence {

    public boolean isSubsequence(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        int left = 0;
        int right = 0;
        while (left < sl && right < tl) {
            if (s.charAt(left) == t.charAt(right++)) {
                left++;
            }
        }

        return left == sl;
    }
}
