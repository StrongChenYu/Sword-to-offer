package sword_to_offer;

import org.junit.Test;

import java.util.ArrayList;

public class JZ41 {

    /**
     * 穷举法stupid solution
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence_Bad(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum <= 1)  return res;

        for (int a = 1; a < sum / 2; a++) {
            for (int b = a + 1; b < sum; b++) {
                int temp = (a + b) * (b - a + 1) / 2;
                if (temp == sum) {
                    System.out.println(temp);
                    ArrayList<Integer> tempRes = new ArrayList<>();
                    for (int i = a; i <= b; i++) {
                        tempRes.add(i);
                    }
                    res.add(tempRes);
                    break;
                }
            }

        }

        return res;
    }

    /**
     * 滑动窗口解法，
     * 其实就是双指针问题
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum <= 1)  return res;

        int left = 1;
        int right = 2;

        while (left <= sum / 2) {

            int tempSum = (right + left) * (right - left + 1) / 2;
            if (tempSum > sum) left++;
            if (tempSum < sum) right++;
            if (tempSum == sum) {
                ArrayList<Integer> tempRes = new ArrayList<>();
                for (int i = left; i <= right; i++) tempRes.add(i);
                res.add(tempRes);

                left = left + 1;

            }
        }

        return res;
    }

    @Test
    public void Test() {
        JZ41 jz41 = new JZ41();
        jz41.FindContinuousSequence(100);
    }

}
