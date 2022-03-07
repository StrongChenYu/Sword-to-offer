package week_contest.n283;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();

        char[] chars = s.toCharArray();
        int num1 = chars[1] - '0';
        int num2 = chars[4] - '0';

        char begin = chars[0];
        char end = chars[3];

        for (char c = begin; c <= end; c++) {
            for (int i = num1; i <= num2; i++) {
                String temp = String.valueOf(c) +
                        i;
                res.add(temp);
            }
        }

        return res;
    }
}
