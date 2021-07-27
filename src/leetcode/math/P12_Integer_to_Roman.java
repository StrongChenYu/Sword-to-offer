package leetcode.math;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Chen Yu
 * @Date 2021/7/26 22:33
 */
public class P12_Integer_to_Roman {

    static HashMap<Integer, String> allRoman = new LinkedHashMap<>(16);

    static {
        allRoman.put(1000, "M");
        allRoman.put(900, "CM");
        allRoman.put(500, "D");
        allRoman.put(400, "CD");
        allRoman.put(100, "C");
        allRoman.put(90, "XC");
        allRoman.put(50, "L");
        allRoman.put(40, "XL");
        allRoman.put(10, "X");
        allRoman.put(9, "IX");
        allRoman.put(5, "V");
        allRoman.put(4, "IV");
        allRoman.put(1, "I");

    }

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        Iterator<Map.Entry<Integer, String>> iterator = allRoman.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            int key = next.getKey();
            while (num >= key) {
                builder.append(next.getValue());
                num -= key;
            }
        }
        return builder.toString();
    }

    @Test
    public void Test() {
        System.out.println(intToRoman(1994));
    }
}
