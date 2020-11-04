package sword_to_offer;

public class JZ37 {

    //先二分查找左端点，在二分查找右端点，然后相减，复杂度O(log(n))
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) return 0;

        int l = GetLeft(array, k);
        int r = GetLeft(array, k + 1);

        if (array[r] == k + 1){

        }

        return 0;
    }

    public int GetLeft(int[]array, int k) {
        int left = 0;
        int right = array.length;
        int mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (array[mid] >= k)  {
                right = mid;
            } else if (array[mid] < k) {
                left = mid + 1;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        JZ37 jz37 = new JZ37();

        int[] a = new int[]{1,2,3,4,4,6};

        System.out.println(jz37.GetLeft(a, 5));
        System.out.println(4 >> 1);
    }
}
