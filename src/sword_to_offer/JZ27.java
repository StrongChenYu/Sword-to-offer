package sword_to_offer;

import java.util.*;

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

        Set<String> resSet = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            char cur = str.charAt(i);
            sb.delete(i, i + 1);

            ArrayList<String> besidesOnes = Permutation(sb.toString());
            for (String s : besidesOnes) {
                String temp = cur + s;
                resSet.add(temp);
            }

            sb.insert(i, cur);
        }

        return new ArrayList<>(resSet);
    }

    public static void main(String[] args) {
        JZ27 jz27 = new JZ27();
        ArrayList<String> res = jz27.Permutation("abc");
        System.out.println(res);

//        StringBuilder sb = new StringBuilder("abcd");
//        sb.delete(3,4);
//        System.out.println(sb.toString());
//
//        sb.insert(3,"d");
//        System.out.println(sb.toString());


//        Set<String> testSet = new LinkedHashSet<>();
//        for (int i = 0; i < 10; i++) {
//            testSet.add((10 - i) + "");
//        }
//
//        System.out.println(testSet);
    }


}
