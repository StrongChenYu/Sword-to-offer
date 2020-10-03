package sword_to_offer;

//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
public class JZ12 {
    //这个题的思路是使用快速幂的思想，就是使用减半的方式每次进行计算
    //这个版本是需要使用递归进行的，时间复杂度O（logN），但由于递归存在函数空间复杂度
    public double PowerRe(double base, int exponent) {
        int absExp = exponent < 0 ? -exponent : exponent;
        double ret = 0.0;

        if (absExp == 0) return 1;
        if (exponent == 1) return base;
        if (exponent == -1) return 1 / base;

        double temp = PowerRe(base, absExp >> 1);
        if (absExp % 2 == 0) {
            ret = temp * temp;
        } else {
            ret = temp * temp * base;
        }

        if (exponent < 0) return 1 / ret;
        else return ret;
    }


    //将递归改写为非递归

    //方法很巧妙
    public double Power(double base, int exponent) {
        int absExp = exponent < 0 ? -exponent : exponent;

        double ret = 1.0;
        double temp = base;

        while (absExp > 0) {
            if ((absExp & 1) == 1) {
                ret = ret * temp;
            }
            temp = temp * temp;
            absExp = absExp >> 1;
        }

        if (exponent < 0) return 1.0 /ret;
        else return ret;
    }

    public static void main(String[] args) {
        JZ12 jz12 = new JZ12();

        System.out.println(jz12.Power(2.0, -1));
    }
}
