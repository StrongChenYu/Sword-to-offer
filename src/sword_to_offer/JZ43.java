package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请
 * 你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要
 * 求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class JZ43 {

    /**
     * so easy!!!!!!
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if (str.length() == 0 || n == 0) return str;

        StringBuilder sb = new StringBuilder(str);
        n = n % sb.length();

        String substring = sb.substring(0, n);
        sb.delete(0, n);

        sb.append(substring);
        return sb.toString();
    }

    @Test
    public void Test() {
        Assert.assertEquals("XYZdefabc", LeftRotateString("abcXYZdef", 3));
        Assert.assertEquals("", LeftRotateString("", 3));
        Assert.assertEquals("abcXYZdef", LeftRotateString("abcXYZdef", "abcXYZdef".length()*100));
    }


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcdefg");
        System.out.println(sb);
    }

}
