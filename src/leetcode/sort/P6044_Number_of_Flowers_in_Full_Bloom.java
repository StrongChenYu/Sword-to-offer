package leetcode.sort;

import java.util.Arrays;

public class P6044_Number_of_Flowers_in_Full_Bloom {
    private static final int START = (int) 1e9;
    private static final int END = (int) -1e9;

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int[][] temp = new int[flowers.length * 2 + persons.length][2];

        int idx = 0;
        for (int i = 0; i < flowers.length; i++) {
            temp[idx][0] = flowers[i][0];
            temp[idx++][1] = START;

            temp[idx][0] = flowers[i][1];
            temp[idx++][1] = END;
        }

        for (int i = 0; i < persons.length; i++) {
            temp[idx][0] = persons[i];
            temp[idx++][1] = i;
        }

        Arrays.sort(temp, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int[] res = new int[persons.length];

        int now = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i][1] == START) {
                now++;
            } else if (temp[i][1] == END) {
                now--;
            } else {
                res[temp[i][1]] = now;
            }
        }

        return res;
    }


}
