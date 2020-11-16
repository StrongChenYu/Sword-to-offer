package leetcode.mathpro;

public class P9_Palindrome_Number {

    //bad solution
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;

        String s = String.valueOf(x);
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }

        return true;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int tempR = 0;
        while (tempR < x) {
            tempR = tempR * 10 + (x % 10);
            x = x / 10;
        }

        return tempR == x || tempR / 10 == x;
    }

    public static void main(String[] args) {
        P9_Palindrome_Number p = new P9_Palindrome_Number();
        System.out.println(p.isPalindrome(123321));
    }
}
