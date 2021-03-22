package sword_to_offer;

/**
 * @Author Chen Yu
 * @Date 2021/3/22 11:04
 */
public class JZ9 {
    public int JumpFloorII(int target) {
        int[] status = new int[target + 1];
        status[0] = 1;
        status[1] = 1;

        for (int i = 2; i <= target; i++) {
            status[i] = status[i - 1] * 2;
        }

        return status[target];
    }
}
