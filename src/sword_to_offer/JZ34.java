package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class JZ34 {


    /**
     * 这个题无非就是这两种做法
     * 1. 先存起来，不管存到哪里反正，然后再遍历字符串寻找只出现一次的
     * 2. 存到有序哈希表里面，然后遍历有序哈希表(事实证明这个里面不行，不能用这种做法(也可以，使用两个值保存）
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar_Method1(String str) {
        if (str == null || str.length() == 0) return -1;

        int[] countLower = new int[26];
        int[] countUpper = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('A' <= c && c <= 'Z') {
                countUpper[c - 'A']++;
            } else if ('a' <= c && c <= 'z') {
                countLower[c - 'a']++;
            }
        }

        int res = -1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('A' <= c && c <= 'Z') {
                if (countUpper[c - 'A'] == 1) {
                    res = i;
                    break;
                };
            } else if ('a' <= c && c <= 'z'){
                if (countLower[c - 'a'] == 1) {
                    res = i;
                    break;
                }
            }
        }

        return res;
    }


    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;
//
//        Map<Character, int[]> map = new LinkedHashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            map.put(c, !map.containsKey(c));
//        }
//
//        for (Map.Entry<Character, Boolean> e : map.entrySet()) {
//
//        }
        return -1;
    }

    @Test
    public void Test() {
        JZ34 jz34 = new JZ34();

        Assert.assertEquals(jz34.FirstNotRepeatingChar("google"), 4);
        Assert.assertEquals(jz34.FirstNotRepeatingChar("g"),0);
        Assert.assertEquals(jz34.FirstNotRepeatingChar(""), -1);
        Assert.assertEquals(jz34.FirstNotRepeatingChar("jjeeffdd"), -1);
        Assert.assertEquals(jz34.FirstNotRepeatingChar("GGGGGLabcLc"), 6);
    }
}
