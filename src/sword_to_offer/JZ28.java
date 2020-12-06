package sword_to_offer;

public class JZ28 {

    /**
     * 分治的思想解决，核心思想是，假设数组分成两半，那么肯定有众数肯定会出现在两个数组中的一个
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution_DAC(int[] array) {
        return DAC_Help_Func(array, 0, array.length - 1);
    }

    /**
     * tips: 数组的区间包括r
     * @param array
     * @param l
     * @param r
     * @return
     */
    public int DAC_Help_Func(int[] array, int l, int r) {

        //递归终止条件
        //if (l > r) return 0;
        if (l == r) return array[l];
        int middle = l + (r - l) / 2;


        int resL = DAC_Help_Func(array, l, middle);
        int resR = DAC_Help_Func(array, middle + 1, r);

        //if (resL == 0 || resR == 0) return 0;

        if (resL == resR) return resL;
        else {
            int countL = 0;
            int countR = 0;
            for (int i = l; i <= r; i++) {
                if (array[i] == resL) countL++;
                if (array[i] == resR) countR++;
            }
            if (countL == countR) return 0;
            return countL > countR ? resL : resR;
        }
    }

    /**
     * 提取公共部分，不过这样的话比上面多进行了一轮循环，还是不太好
     * @param nums
     * @param num
     * @param lo
     * @param hi
     * @return
     */
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * 选举人算法，这个算法能判断出一个数组里面，最多的人数
     * 但是，最多的人数不太表超过半数，所以需要进行第二次判断
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) return 0;

        int major = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            int n = array[i];
            if (n == major || count == 0) {
                major = n;
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (major == array[i]) count++;
        }

        return count > array.length / 2 ? major : 0;
    }

    /**
     * 用快排的思想解决这个问题
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution_QuickSort(int [] array) {
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
        int[] a = new int[]{1,2,3,3,3,3};
        //jz28.partition(a, a.length - 2, a.length - 2, a.length);
        //printArray(a);
        System.out.println(jz28.MoreThanHalfNum_Solution_DAC(a));
    }
}
