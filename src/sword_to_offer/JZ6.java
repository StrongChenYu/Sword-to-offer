package sword_to_offer;

public class JZ6 {
//
//    public static void main(String[] args) {
//        int[] array = new int[]{3,1,2};
//        System.out.println(minNumberInRotateArray(array));
//    }

    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) return 0;

        int l = 0;
        int r = array.length - 1;
        int mid = l + (r - l) / 2;

        while (l < r) {

            mid = l + (r - l) / 2;

            if (array[l] == array[mid] && array[mid] == array[r]) return findMinInOrder(array);

            if (array[mid] < array[r]) r = mid;
            else if (array[mid] > array[l]) l = mid;
            else if (array[mid] == array[l]) break;

        }

        return array[r];
    }


    public int findMinInOrder(int [] num) {
        int min = 0;
        for (int n : num) {
            min = Math.min(n, min);
        }
        return min;
    }

}