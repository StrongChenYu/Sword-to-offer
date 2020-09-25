package sword_to_offer;

public class JZ13 {
    public void reOrderArray(int [] array) {
        if (array == null || array.length <= 1) return;

        int leftIndex = -1;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (num % 2 == 1) {
                int j = i;
                while (j > leftIndex + 1) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[++leftIndex] = num;
            }
        }
    }

    public static void main(String[] args) {
        JZ13 jz13 = new JZ13();
        int[] a = new int[]{3,2,1,3,45,3};
        jz13.reOrderArray(a);

        System.out.println(a);
    }
}
