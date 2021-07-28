package leetcode.string;

/**
 * @Author Chen Yu
 * @Date 2021/7/28 9:11
 */
public class P14_Longest_Common_Prefix {

    public static void main(String[] args) {
        String s = "123";
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int curIdx = 0;
        while (true) {
            boolean breakFlag = false;

            if (curIdx >= strs[0].length()) {
                return strs[0].substring(0, curIdx);
            }

            char cur = strs[0].charAt(curIdx);
            for (int i = 1; i < strs.length; i++) {
                if (curIdx >= strs[i].length()) {
                    return strs[0].substring(0, curIdx);
                }

                if (strs[i].charAt(curIdx) != cur) {
                    return strs[0].substring(0, curIdx);
                }
            }

            curIdx++;
        }
    }
}
