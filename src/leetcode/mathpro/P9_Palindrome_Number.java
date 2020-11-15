package leetcode.mathpro;

public class P9_Palindrome_Number {

    //bad solution
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        String s = String.valueOf(x);
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        P9_Palindrome_Number p = new P9_Palindrome_Number();
        System.out.println(p.isPalindrome(0));
    }
}
