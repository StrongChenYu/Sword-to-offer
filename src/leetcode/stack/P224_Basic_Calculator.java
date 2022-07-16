package leetcode.stack;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class P224_Basic_Calculator {

    private static HashMap<Character, Integer> opsPriority = new HashMap<>();

    static {
        opsPriority.put('+', 1);
        opsPriority.put('-', 1);
        opsPriority.put('(', 0);
        opsPriority.put(')', 0);
    }

    public int calculate(String s) {
        String s1 = insertSingleOp(s);
        String calStr = transform(s1);
        System.out.println("cal=" + calStr);
        String[] eles = calStr.split(" ");

        Deque<Integer> nums = new LinkedList<>();
        for (String ele : eles) {
            if (ele.equals("+")) {
                // +
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num1 + num2);
            } else if (ele.equals("-")) {
                // -
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num2 - num1);
            } else {
                // 数字
                int num = 0;
                for (int i = 0; i < ele.length(); i++) {
                    num = num * 10 + ele.charAt(i) - '0';
                }
                nums.push(num);
            }
        }

        return nums.pop();
    }

    public String transform(String str) {
        StringBuilder builder = new StringBuilder();

        // 转化为逆波兰表达式
        Deque<Character> ops = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '+':
                case '-':
                    int curPri = opsPriority.get(c);
                    while (!ops.isEmpty() && opsPriority.get(ops.peek()) >= curPri) {
                        builder.append(ops.pop());
                        builder.append(' ');
                    }
                    ops.push(c);
                    break;
                case '(':
                    ops.push(c);
                    break;
                case ')':
                    while (ops.peek() != '(') {
                        builder.append(ops.pop());
                        builder.append(' ');
                    }
                    // final pop (
                    ops.pop();
                    break;
                default:
                    // 数字情况
                    builder.append(c);
                    while (i + 1 < str.length() && str.charAt(i + 1) - '0' >= 0 && str.charAt(i + 1) - '0' <= 9) {
                        builder.append(str.charAt(++i));
                    }
                    builder.append(' ');
            }
        }

        while (!ops.isEmpty()) {
            builder.append(ops.pop());
        }

        return builder.toString();
    }

    // 主要判断-号
    private String insertSingleOp(String s) {
        StringBuilder builder = new StringBuilder();

        /*
             1. -号前没有值(只有可能出现在头部）
             2. -号前为(
             题目中不可能出现两个连着的运算符，所以只有这两种情况
         */

        if (s.charAt(0) == '-') {
            builder.append(0);
            builder.append('-');
        } else if (s.charAt(0) != ' ') {
            builder.append(s.charAt(0));
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;

            if (s.charAt(i) == '-' && s.charAt(i - 1) == '(') {
                builder.append(0);
                builder.append('-');
            } else {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }


    @Test
    public void test() {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
//        System.out.println(calculate("1 + 1"));
//        System.out.println(calculate(" 2-1 + 2 "));
//        System.out.println(calculate("-2+1"));
//        System.out.println(calculate("-2+(-(-1))"));
    }
}
