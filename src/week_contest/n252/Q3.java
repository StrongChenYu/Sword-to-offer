package week_contest.n252;

import org.junit.Test;

public class Q3 {

    public long minimumPerimeter(long neededApples) {

        long x = 1;
        while (true) {
            int curApple = 0;
            //根据x计算apple
            int times = 1;
            for (long i = 0; i < x; i++) {
                curApple += i * times;
                times++;
            }

            times = 1;
            for (long i = x * 2; i >= x + 1; i--) {
                curApple += i * times;
                times++;
            }

            int sum = 0;
            for (int i = 0; i <= x; i++) {
                sum += i;
            }

            curApple += x * (x + 1);
            curApple -= sum * 2;

            curApple = curApple * 4;

            curApple += sum * 4;



            if (curApple >= neededApples) {
                break;
            }
            x++;
        }

        return 8 * x;
    }

    @Test
    public void Test() {
        //System.out.println(minimumPerimeter(1));
        System.out.println(minimumPerimeter(13));
        System.out.println(minimumPerimeter(16));
        System.out.println(minimumPerimeter(12));
        System.out.println(minimumPerimeter(1000000000));
    }
}
