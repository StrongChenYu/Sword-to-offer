package sword_to_offer;

import java.util.Stack;

public class JZ21 {


    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();

        int curPush = 0;
        int curPop = 0;

        while (curPush < pushA.length) {
            stack.push(pushA[curPush++]);
            while (curPop < popA.length && stack.peek() == popA[curPop]) {
                stack.pop();
                curPop++;
            }
        }

        return stack.isEmpty();
    }
}
