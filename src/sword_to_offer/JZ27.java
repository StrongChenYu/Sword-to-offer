package sword_to_offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class JZ27 {
    //先把使用交换来设定顺序
    public ArrayList<String> Permutation(String str) {
        if (str == null) return null;
        if (str.equals("")) return new ArrayList<>();
        if (str.length() == 1) {
            ArrayList<String> res = new ArrayList<>();
            res.add(str);
            return res;
        }

        Set<String> resSet = new HashSet<>();
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            char cur = str.charAt(i);

            sb.setCharAt(i, sb.charAt(0));
            sb.setCharAt(0, cur);

            ArrayList<String> besidesOnes = Permutation(sb.substring(1));
            for (String s : besidesOnes) {
                String temp = cur + s;
                resSet.add(temp);
            }

            sb.setCharAt(0, sb.charAt(i));
            sb.setCharAt(i, cur);
        }

        return new ArrayList<>(resSet);
    }

    public static void main(String[] args) {
        JZ27 jz27 = new JZ27();
        ArrayList<String> res = jz27.Permutation("aab");
        System.out.println(res);
    }


}
