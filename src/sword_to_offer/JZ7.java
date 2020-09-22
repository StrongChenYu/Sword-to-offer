package sword_to_offer;

public class JZ7 {
    public int Fibonacci(int n) {
        int a = 0;
        int b = 1;
        
        if (n == 0) return a;
        if (n == 1) return b;
        
        for (int i = 0; i < n - 1; i ++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        
        return b;
    }
}
