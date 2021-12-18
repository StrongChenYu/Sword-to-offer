package leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P394_Decode_String {

    public String decodeString(String s) {

        char[] chars = s.toCharArray();
        Deque<Integer> multiStack = new LinkedList<>();
        Deque<StringBuilder> resStack = new LinkedList<>();

        int multi = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                multiStack.push(multi);
                resStack.push(res);

                multi = 0;
                res = new StringBuilder();
            } else if (chars[i] == ']') {
                // 出栈然后计算值
                StringBuilder pre = resStack.pop();
                int repeatTime = multiStack.pop();

                for (int k = 0; k < repeatTime; k++) {
                    pre.append(res);
                }

                res = pre;
            } else if (chars[i] - '0' >= 0 && chars[i] - '0' <= 9) {
                multi = multi * 10 + (chars[i] - '0');
            } else {
                // 字母
                res.append(chars[i]);
            }
        }

        return res.toString();
    }

    @Test
    public void Test() {
        System.out.println(decodeString("3[a2[c]]"));
    }
}
