package week_contest.n273;

import org.junit.Test;

public class P2 {

    public int[] executeInstructions(int n, int[] startPos, String s) {
        char[] introductions = s.toCharArray();
        int[] res = new int[introductions.length];

        for (int i = 0; i < introductions.length; i++) {
            int cnt = 0;
            int row = startPos[0];
            int col = startPos[1];
            for (int j = i; j < introductions.length; j++) {
                switch (introductions[j]) {
                    case 'L':
                        col--;
                        break;
                    case 'R':
                        col++;
                        break;
                    case 'U':
                        row--;
                        break;
                    case 'D':
                        row++;
                        break;
                }

                if (row < 0 || row >= n || col < 0 || col >= n) {
                    break;
                }
                cnt++;
            }
            res[i] = cnt;
        }

        return res;
    }

    @Test
    public void Test() {
        executeInstructions(1, new int[]{0,0}, "LRUD");
    }
}
