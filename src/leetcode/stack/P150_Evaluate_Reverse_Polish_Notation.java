package leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Chen Yu
 * @Date 2021/4/20 8:33
 */
public class P150_Evaluate_Reverse_Polish_Notation {

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < tokens.length; i++) {
            int op1 = 0;
            int op2 = 0;

            switch (tokens[i]) {
                case "+":
                    //op1 操作 op2
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 + op2);
                    break;
                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 - op2);
                    break;
                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 / op2);
                    break;
                case "*":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 * op2);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }

    String[][] testData = {
            {"2","1","+","3","*"},
            {"4","13","5","/","+"},
            {"10","6","9","3","+","-11","*","/","*","17","+","5","+"},
            {"2","100","/"}
    };

    int[] expectedResult = {
            9,
            6,
            22,
            0,
    };

    @Test
    public void Test() {
        for (int i = 0; i < testData.length; i++) {
            Assert.assertEquals(expectedResult[i], evalRPN(testData[i]));
        }
    }

}
