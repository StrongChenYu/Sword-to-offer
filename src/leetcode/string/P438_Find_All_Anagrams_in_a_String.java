package leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P438_Find_All_Anagrams_in_a_String {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int sL = s.length();
        int pL = p.length();

        int[] cntWindow = new int[26];
        int[] cntP = new int[26];

        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();

        // 先统计p字符串中的频率
        for (char c : charP) {
            cntP[c - 'a']++;
        }

        int left = 0;
        int right = 0;

        for (; right < sL; right++) {
            int cntIdx = charS[right] - 'a';
            cntWindow[cntIdx]++;

            while (cntWindow[cntIdx] > cntP[cntIdx]) {
                cntWindow[charS[left] - 'a']--;
                left++;
            }

            if (Arrays.equals(cntWindow, cntP)) {
                res.add(left);
            }
        }

        return res;
    }


    @Test
    public void test() {
        System.out.println(findAnagrams("abba", "ab"));
    }
}
