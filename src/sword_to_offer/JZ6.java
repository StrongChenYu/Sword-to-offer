package sword_to_offer;

public class JZ6 {

    public static void main(String[] args) {
        int[] array = new int[]{3,4,5,1,2};
        System.out.println(minNumberInRotateArray(array));
    }

    public static int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) return 0;

        int l = 0;
        int r = array.length - 1;
        int mid = l + (r - l) / 2;

        while (l < r) {
            mid = l + (r - l) / 2;
            if (array[mid] < array[l]) r = mid;
            else if (array[mid] > array[r]) l = mid;
            else {

            }
            System.out.println("l =" + l);
            System.out.println("r =" + r);
        }

        return array[mid];
    }

}
