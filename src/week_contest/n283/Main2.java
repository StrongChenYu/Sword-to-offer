package week_contest.n283;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main2 {
    public long minimalKSum(int[] nums, int k) {
        // 默认就是小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.offer(num);
        }
        heap.offer(Integer.MAX_VALUE);

        long sum = 0;
        int addCnt = 0;

        int leftBound = 1;
        while (addCnt < k) {
            int topNum = heap.poll();
            //[leftBound, topNum) 元素加起来
            //如果区间为空，直接下一个
            if (leftBound >= topNum) {
                leftBound = topNum + 1;
                continue;
            }

            // 区间不为空
            // 区间长度，也是要加的长度
            int addLength = topNum - leftBound;
            // 区间长度怎么解决

            // 如果要加的长度小于剩下的次数
            int actualRight = 0;
            if (addCnt + addLength <= k) {
                // 直接计算就行了，反正是连续的
                actualRight = topNum;
            } else {
                int leftCnt = k - addCnt;
                actualRight = leftBound + leftCnt;
            }

            int n = actualRight - leftBound;
            sum += (long) (leftBound + actualRight - 1) * n / 2;
            addCnt += n;

            if (addCnt == k) {
                break;
            }
            leftBound = topNum + 1;
        }

        return sum;
    }

    @Test
    public void test() {
        System.out.println(minimalKSum(new int[]{5,6}, 6));
    }

    public static void main(String[] args) {
    }
}
