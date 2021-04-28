package leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Chen Yu
 * @Date 2021/4/28 8:53
 */
public class P179_Largest_Number {

    /**
     * 直接按字典序排
     * 然后返回结果就行了
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] numsList = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsList[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        StringBuilder s = new StringBuilder();
        for (String num : numsList) {
            if (s.length() == 0 && num.equals("0")) {
                continue;
            }

            s.append(num);
        }
        String res = s.toString();
        return res.equals("") ? "0" : res;
    }
}
