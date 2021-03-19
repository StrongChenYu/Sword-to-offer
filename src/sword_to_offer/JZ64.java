package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author Chen Yu
 * @Date 2021/3/18 21:41
 */
public class JZ64 {


    /**
     * 使用堆来实现
     * 用一个最大堆来实现
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        Queue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        ArrayList<Integer> res = new ArrayList<>();

        if (num == null || num.length == 0 || num.length < size || size == 0) {
            return res;
        }

        int count = 0;
        for (; count < size; count++) {
            maxQueue.offer(num[count]);
        }

        while (count < num.length) {
            Integer peek = maxQueue.peek();
            res.add(peek);

            maxQueue.remove(num[count - size]);
            maxQueue.offer(num[count++]);
        }

        res.add(maxQueue.peek());

        return res;
    }

    int[][] testNum = {
            {2,3,4,2,6,2,5,1}
    };

    int[] testSize = {
            3,
    };

    int[][] testRes = {
            {4,4,6,6,6,5}
    };

    @Test
    public void Test() {
        int testUnitSize = testNum.length;

        for (int i = 0; i < testUnitSize; i++) {
            ArrayList<Integer> gotArrays = maxInWindows(testNum[i], testSize[i]);
            int[] wantArrays = testRes[i];
            Assert.assertEquals(wantArrays.length, gotArrays.size());
            for (int j = 0; j < wantArrays[j]; j++) {
                Integer got = gotArrays.get(j);
                int want = wantArrays[j];

                Assert.assertEquals(got.intValue(), want);
            }
        }
    }


    public static void main(String[] args) {
        Queue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        maxQueue.offer(1);
        maxQueue.offer(3);
        maxQueue.offer(4);
        maxQueue.offer(2);

        while (!maxQueue.isEmpty()) {
            System.out.println(maxQueue.poll());
        }
    }
}
