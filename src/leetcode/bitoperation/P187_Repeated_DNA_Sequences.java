package leetcode.bitoperation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author Chen Yu
 * @Date 2021/5/1 15:19
 */
public class P187_Repeated_DNA_Sequences {

    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> mem = new HashMap<>();

        int cur = 0;
        for (; cur + 10 <= s.length(); cur ++) {
            String temp = s.substring(cur, cur + 10);
            mem.put(temp, mem.getOrDefault(temp, 0) + 1);
        }

        List<String> res = new ArrayList<>();
        mem.forEach((key, value) -> {
            if (value > 1) res.add(key);
        });

        return res;
    }

    @Test
    public void Test() {
        findRepeatedDnaSequences("AAAAAAAAAAAAA");
    }
}
