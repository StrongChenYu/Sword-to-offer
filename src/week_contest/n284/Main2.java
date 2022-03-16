package week_contest.n284;
import org.junit.Test;

public class Main2 {

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] isDig = new boolean[n][n];

        for (int i = 0; i < dig.length; i++) {
            isDig[dig[i][0]][dig[i][1]] = true;
        }

        int cnt = 0;
        for (int[] artifact : artifacts) {
            boolean isDigBoard = true;
            for (int i = artifact[0]; i <= artifact[2]; i++) {
                for (int j = artifact[1]; j <= artifact[3]; j++) {
                    if (!isDig[i][j]) {
                        isDigBoard = false;
                    }
                }
            }

            if (isDigBoard) cnt++;
        }

        return cnt;
    }

    @Test
    public void test() {

    }

    public static void main(String[] args) {
    }
}
