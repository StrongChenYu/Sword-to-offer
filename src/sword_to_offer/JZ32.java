package sword_to_offer;

import java.util.Arrays;
import java.util.Comparator;

//主要是贪心的思想
public class JZ32 {

    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        String[] ns = new String[numbers.length];

        for (int i = 0; i < ns.length; i++) {
            ns[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(ns, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return (s + t1).compareTo(t1 + s);
            }
        });


        StringBuilder sb = new StringBuilder();
        for (String s : ns) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3,32,321,1,2,3,4};

        JZ32 jz32 = new JZ32();

        System.out.println(jz32.PrintMinNumber(numbers));

    }

}


