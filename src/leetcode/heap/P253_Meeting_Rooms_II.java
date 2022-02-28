package leetcode.heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P253_Meeting_Rooms_II {

    private int[][] data = {
            {2,15},{36,45},{9,29},{16,23},{4,9}
    };

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) return intervals.length;

        assert intervals[0].length == 2;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        maxHeap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] top = maxHeap.peek();

            //如果top的最小的结束时间 > 当前的起始时间，说明会还没开完，需要新的房间
            if (top[1] > intervals[i][0]) {
                maxHeap.offer(intervals[i]);
            } else {
                //如果top的最小的结束时间 <= 当前的最小结束时间
                // 把top的结束时间更新了，因为是引用，所以不用poll
                // !!! 更改后堆是不会进行重排序的
                maxHeap.poll();
                maxHeap.offer(intervals[i]);
            }
        }

        return maxHeap.size();
    }


    @Test
    public void test() {
        minMeetingRooms(data);
    }
}
