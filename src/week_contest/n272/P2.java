package week_contest.n272;

import org.junit.Test;

public class P2 {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder(s);
        for (int i = 0; i < spaces.length; i++) {
            res.append(" ");
        }

        int r = res.length() - 1;
        int l = s.length() - 1;
        int spaceIdx = spaces.length - 1;

        while (l != r && spaceIdx >= 0) {
            if (l + 1 == spaces[spaceIdx]) {
                spaceIdx--;
                res.setCharAt(r--, ' ');
            } else {
                res.setCharAt(r--, s.charAt(l--));
            }
        }

        return res.toString();
    }

    @Test
    public void Test() {
        System.out.println(addSpaces("s", new int[]{}));
    }
}
