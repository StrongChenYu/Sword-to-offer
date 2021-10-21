package leetcode.unionfind;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * @Author Chen Yu
 * @Date 2021/10/20 23:41
 */
public class P128_Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> mem = new HashSet<>();
        for (int num : nums) {
            mem.add(num);
        }
        int cnt = 0;
        for (Integer num : mem) {
            if (mem.contains(num - 1)) {
                continue;
            }
            int tempCnt = 1;
            int tempNum = num;
            while (mem.contains(tempNum + 1)) {
                tempNum++;
                tempCnt++;
            }
            cnt = Math.max(tempCnt, cnt);
        }

        return cnt;
    }

    @Test
    public void Test() {
        Assert.assertEquals(longestConsecutive(new int[]{100,4,200,1,3,2}), 4);
        Assert.assertEquals(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}), 9);
        Assert.assertEquals(longestConsecutive(new int[]{0}), 1);
        Assert.assertEquals(longestConsecutive(new int[]{0,3,7}), 1);
    }


}
