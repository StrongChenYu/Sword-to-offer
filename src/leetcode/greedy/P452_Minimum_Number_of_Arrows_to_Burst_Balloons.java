package leetcode.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class P452_Minimum_Number_of_Arrows_to_Burst_Balloons {

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int cnt = 1;
        int preEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] < preEnd) {
                continue;
            }
            cnt++;
            preEnd = points[i][1];
        }

        return cnt;
    }

    @Test
    public void test() {
        int[][] data = {{-2147483646,-2147483645},{2147483646,2147483647}};

        System.out.println(findMinArrowShots(data));
    }

    public static void main(String[] args) {
        System.out.println(-2147483645 - 2147483647);
    }
}
