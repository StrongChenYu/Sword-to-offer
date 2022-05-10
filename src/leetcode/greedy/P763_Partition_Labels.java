package leetcode.greedy;

import org.junit.Test;

import java.util.*;

public class P763_Partition_Labels {

    public List<Integer> partitionLabels(String s) {
        int[][] arr = new int[26][2];

        for (int i = 0; i < 26; i++) {
            arr[i][0] = -1;
            arr[i][1] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if (arr[idx][0] == -1 && arr[idx][1] == -1) {
                // 说明这个区间还没有被赋值过
                // 也就是说明之前没有遇到过这种字符
                arr[idx][0] = i;
                arr[idx][1] = i;
            } else {
                arr[idx][1] = i;
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<Integer> result = new ArrayList<>();

        // ship -1
        int idx = 0;
        for (; arr[idx][0] == -1 && arr[idx][1] == -1; idx++);

        int preStart = arr[idx][0];
        int preEnd = arr[idx][1];
        for (int i = idx + 1; i < arr.length; i++) {
            if (arr[i][0] > preEnd) {
                // 不可能出现等于的情况！
                // 说明从这里开始要开始新的区间
                int len = preEnd - preStart + 1;
                result.add(len);

                preStart = arr[i][0];
                preEnd = arr[i][1];
            } else {
                preEnd = Math.max(preEnd, arr[i][1]);
            }
        }

        // 更新一下最后生成的区间
        result.add(preEnd - preStart + 1);

        return result;
    }

    @Test
    public void test() {
        partitionLabels("abab");
    }
}
