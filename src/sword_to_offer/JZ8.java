package sword_to_offer;

public class JZ8 {
    public int JumpFloor(int target) {
        if (target == 1) return 1;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= target; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        //1,2,3,5,8
        return b;
    }
}
