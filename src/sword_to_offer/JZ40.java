package sword_to_offer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JZ40 {

    public void FindNumsAppearOnce(int [] array, int num1[], int num2[]) {

        int xor = 0;
        for (int a : array) xor = xor ^ a;

        xor = xor & (-xor);


        num1[0] = 0;
        num2[0] = 0;
        for (int a : array) {
            if ((xor & a) == 0) num1[0] ^= a;
            else num2[0] ^= a;
        }
    }


    public void FindNumsAppearOnce_BigSpaceCost(int [] array,int num1[] , int num2[]) {
        Set<Integer> count = new HashSet<>();

        for (int a : array) {
            if (!count.contains(a))
                count.add(a);
            else {
                count.remove(a);
            }
        }

        Iterator<Integer> iterator = count.iterator();
        num1[0] = iterator.next();
        num2[0] = iterator.next();
    }

    @Test
    public void MyTest() {
        JZ40 jz40 = new JZ40();
        int[] num1 = new int[1];
        int[] num2 = new int[1];


        int[] array = new int[]{1,2,2,3};
        jz40.FindNumsAppearOnce(array, num1, num2);

        System.out.println(1 ^ 2);
    }
}
