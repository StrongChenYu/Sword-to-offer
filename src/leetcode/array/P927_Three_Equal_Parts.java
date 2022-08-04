package leetcode.array;

public class P927_Three_Equal_Parts {

    public int[] threeEqualParts(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += arr[i] == 1 ? 1 : 0;
        }

        if (cnt % 3 != 0) {
            return new int[]{-1, -1};
        }


        if (cnt == 0) {
            // 全都是0
            return new int[]{0, 2};
        }

        int part1Cnt = cnt / 3;

        //[0,left0) prefix 0
        //[left0, left1) first num

        //[right0, arr.length) suffix 0
        //[right1, right0) last num

        //[left1, right1) middle num
        int left0 = 0;
        int left1 = 0;
        int right0 = arr.length;
        int right1 = 0;

        for (; arr[left0] == 0; left0++);
        for (; arr[right0 - 1] == 0; right0--);
        int right0Cnt = arr.length - right0;

        // 第一部分跳过cnt/3个1
        int leftCnt = 0;
        for (left1 = left0; leftCnt < part1Cnt; left1++) {
            if (arr[left1] == 1) {
                leftCnt++;
            }
        }

        // 第一部分跳过right0Cnt个0
        int left0Cnt = 0;
        for (; left0Cnt < right0Cnt; left1++) {
            if (arr[left1] == 0) {
                left0Cnt++;
            } else {
                return new int[]{-1, -1};
            }
        }

        // 第三部分跳过cnt/3个1
        int rightCnt = 0;
        for (right1 = right0; rightCnt < part1Cnt; right1--) {
            if (arr[right1 - 1] == 1) {
                rightCnt++;
            }
        }

        // 中间部分跳过cnt / 3个1
        int middleRightBound = left1;
        int middle1Cnt = 0;
        int middle0Cnt = 0;
        for (; middle1Cnt < part1Cnt; middleRightBound++) {
            if (arr[middleRightBound] == 1) {
                middle1Cnt++;
            }
        }

        for (; middle0Cnt < right0Cnt; middleRightBound++) {
            if (arr[middleRightBound] == 0) {
                middle0Cnt++;
            } else {
                return new int[]{-1, -1};
            }
        }


        // 接下来判断三个区间除0之外是否相同，只需要知道区间右bound就行
        //[0, left1)
        //[left1, middleRightBound)
        //[middleRightBound, arr.length)

        int i = left1;
        int j = middleRightBound;
        int k = arr.length;

        while (i > left0 && j > left1 && k > middleRightBound) {
            if (arr[i - 1] == arr[j - 1] && arr[j - 1] == arr[k - 1]) {
                i--;
                j--;
                k--;
            } else {
                return new int[]{-1, -1};
            }
        }
        //1: [0, res[0]]
        //2: [res[0] + 1, res[1] - 1]
        //3: [res[1], arr.length - 1]
        return new int[]{left1 - 1, middleRightBound};
    }
}
