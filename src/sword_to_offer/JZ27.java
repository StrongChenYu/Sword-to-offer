package sword_to_offer;

import java.util.*;

public class JZ27 {
    //先把使用交换来设定顺序
    //bad solution
    public ArrayList<String> PermutationBad(String str) {
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

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) return new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();

        Recursion(str.toCharArray(), 0, res);
        Collections.sort(res);

        return res;
    }

    public void Recursion(char[] chars, int starIndex, ArrayList<String> res) {
        if (chars.length - 1 == starIndex) {
            res.add(String.valueOf(chars));
        } else {
            HashSet<Character> charSet = new HashSet<>();
            for (int i = starIndex; i < chars.length; i++) {
                if (!charSet.contains(chars[i])) {
                    charSet.add(chars[i]);
                    swap(chars, starIndex, i);
                    Recursion(chars, starIndex + 1, res);
                    swap(chars, i, starIndex);
                }
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
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
