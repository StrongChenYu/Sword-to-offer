package practice;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * 美团2020校招系统开发方向笔试题
 * https://www.nowcoder.com/question/next?pid=21910856&qid=894502&tid=58430661
 */
public class Main2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num1 = scanner.nextLine();
        String num2 = scanner.nextLine();

        System.out.println(add(num1, num2));
    }

    private static String add(String num1, String num2) {
        num1 = num1.substring(1, num1.length() - 1);
        num2 = num2.substring(1, num2.length() - 1);
        // 先假设没有双引号
        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);

        BigInteger res = n1.add(n2);
        return "\"" + res.toString() + "\"";
    }
}
