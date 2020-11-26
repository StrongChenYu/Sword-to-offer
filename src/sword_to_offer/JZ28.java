package sword_to_offer;

public class JZ28 {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return 0;

        int l = 0;
        int r = array.length;
        int cur = l;
        while (cur < r) {
            partition(array, cur, l, r);
            int curNum = array[cur];
            if (array[r / 2] == curNum){
                return curNum;
            }
            else if (array[r / 2] > curNum) {
                partition(array, cur, l, r);
            } else {
                partition(array, cur, l, r);
            }
        }
        return 0;
    }


    // from left to right-1, array[right] has nothing.
    public void partition(int[] array, int index, int left, int right) {
        if (left == right) return;

        int targetNum = array[index];

        int l = left - 1;
        int r = right;
        int cur = left;
        while (cur < r) {
            int curNum = array[cur];
            if (curNum > targetNum) {
                //当前值，比目标值大，需要换到后面去
                swap(array, cur, --r);
            } else if (curNum < targetNum) {
                swap(array, cur++, ++l);
            } else {
                cur++;
            }
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        JZ28 jz28 = new JZ28();
        int[] a = new int[]{1,2,8,7,1,4,5,3,5};
        jz28.partition(a, a.length - 2, a.length - 2, a.length);
        //printArray(a);
    }
}
