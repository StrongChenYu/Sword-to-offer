package week_contest.n273;

import org.junit.Test;

import java.util.*;

public class P3 {

    public long[] getDistances(int[] arr) {
        long[] front = new long[arr.length];
        long[] back = new long[arr.length];
        long[] res = new long[arr.length];
        Map<Integer, int[]> mem = new HashMap<>();
        // int[0]: last index
        // int[1]: appear times
        for (int i = 0; i < arr.length; i++) {
            if (mem.containsKey(arr[i])) {
                int[] val = mem.get(arr[i]);
                front[i] = front[val[0]] + (long) val[1] * (i - val[0]);
                val[0] = i;
                val[1] = val[1] + 1;
            } else {
                mem.put(arr[i], new int[]{i, 1});
            }
        }

        mem.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (mem.containsKey(arr[i])) {
                int[] val = mem.get(arr[i]);
                back[i] = back[val[0]] + (long) val[1] * (val[0] - i);
                val[0] = i;
                val[1] = val[1] + 1;
            } else {
                mem.put(arr[i], new int[]{i, 1});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            res[i] = front[i] + back[i];
        }

        return res;
    }

    @Test
    public void Test() {
        getDistances(new int[]{5,5});
    }
}
