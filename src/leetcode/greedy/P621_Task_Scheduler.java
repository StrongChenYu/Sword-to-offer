package leetcode.greedy;

import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class P621_Task_Scheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];

        for (char task : tasks) {
            cnt[task - '0']++;
        }

        int maxCnt = 0;
        int max = 0;
        for(int i = 0; i < 26; i++) {
            max = Math.max(max, cnt[i]);
        }

        for(int i = 0; i < 26; i++) {
            maxCnt = max == cnt[i] ? maxCnt + 1 : maxCnt;
        }

        int res = (max - 1) * (n + 1) + maxCnt;
        return Math.max(res, tasks.length);
    }


    @Test
    public void test() {

    }

    public static void main(String[] args) {

    }
}
