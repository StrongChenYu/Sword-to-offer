package sword_to_offer;

/**
 * @Author Chen Yu
 * @Date 2021/3/22 11:05
 */
public class JZ10 {
    public int RectCover(int target) {
        if (target == 0) return 0;
        int a = 0;
        int b = 1;
        for (int i = 1; i <= target; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
