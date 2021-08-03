package week_contest.n252;

import org.junit.Test;

import java.util.Arrays;

public class Q2 {

    public long numberOfWeeks(int[] milestones) {
        if (milestones.length <= 1) {
            return 1;
        }

        Arrays.sort(milestones);
        long max = Integer.MIN_VALUE;
        long sum = milestones[0];
        for (int i = 1; i < milestones.length; i++) {
            if (milestones[i] == sum) {
                max = Math.max(max, 2 * sum);
            } else if (sum < milestones[i]){
                max = Math.max(max, 2 * Math.min(sum, milestones[i]) + 1);
            } else {
                max = Math.max(max, sum + milestones[i]);
            }
            sum += milestones[i];
        }

        return max;
    }

    @Test
    public void Test() {
        System.out.println(numberOfWeeks(new int[]{1, 2, 3}));
        System.out.println(numberOfWeeks(new int[]{5,2,1}));
        System.out.println(numberOfWeeks(new int[]{9,3,6,8,2,1}));
    }
}
