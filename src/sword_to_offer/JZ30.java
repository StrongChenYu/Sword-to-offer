package sword_to_offer;

public class JZ30 {

    private final int MAX = 0;
    private final int LEFT = 1;
    private final int RIGHT = 2;


    /**
     * 核心思想就在于，如果先直接用迭代的方式解决的话，时间复杂度很高
     * 优化：使用二维数组保存i-j之间的和，以防止重复计算
     *
     * 更简单的思想在于，保存以dp[i]描述的是：
     * ****以num[i]为结尾，连续子树组的最大值
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArrayDP(int[] array) {
        if (array == null || array.length == 0) return 0;
        int n = array.length;

        int[] status = new int[n];
        status[0] = array[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            status[i] = Math.max(array[i], status[i - 1] + array[i]);
            res = Math.max(res, status[i]);
        }

        return res;
    }




    /**
     * 分治解决，其实就是分开递归
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] res = RecursionFunc(array,0,array.length);
        System.out.println("leftBound:" + res[LEFT] + " rightBound:" + res[RIGHT]);
        return res[MAX];
    }

    /**
     * 1. the range of index is left <= x < right
     * 2. return array[0] is maxValue, array[1] is leftBound, array[2] is right Bound, not include right
     * @param array
     * @param left
     * @param right
     * @return
     */
    public int[] RecursionFunc(int[] array, int left, int right) {
        int[] res = new int[3];

        if (right - left == 1) return giveArrayValue(res, array[left], left, right);

        int middle = left + ((right - left) >> 1);
        int[] leftRes = RecursionFunc(array, left, middle);
        int[] rightRes = RecursionFunc(array, middle, right);


        int addValue = leftRes[MAX] + rightRes[MAX];
        if (leftRes[RIGHT] == rightRes[LEFT] && addValue > leftRes[MAX] && addValue > rightRes[MAX]) {
            return giveArrayValue(res, leftRes[MAX] + rightRes[MAX] , leftRes[LEFT], rightRes[RIGHT]);
        } else if (leftRes[MAX] >= rightRes[MAX]){
            return giveArrayValue(res, leftRes[MAX], leftRes[LEFT], rightRes[RIGHT]);
        } else {
            return giveArrayValue(res, rightRes[MAX], leftRes[LEFT], rightRes[RIGHT]);
        }
    }

    public int[] giveArrayValue(int[] arr, int a1, int a2, int a3) {
        arr[0] = a1;
        arr[1] = a2;
        arr[2] = a3;
        return arr;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,-2,3,10,-4,7,2,-5};
        JZ30 jz30 = new JZ30();
        System.out.println(jz30.FindGreatestSumOfSubArray(array));
    }
}
