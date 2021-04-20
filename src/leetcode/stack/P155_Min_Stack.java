package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author Chen Yu
 * @Date 2021/4/20 8:50
 */
public class P155_Min_Stack {

}

class MinStack {
    Deque<Integer> originStack;
    Deque<Integer> minStack;

    public MinStack() {
        minStack = new LinkedList<>();
        originStack = new LinkedList<>();
    }

    public void push(int val) {
        originStack.push(val);

        if (!minStack.isEmpty()) {
            int top = minStack.peek();
            if (top <= val) {
                minStack.push(top);
            } else {
                minStack.push(val);
            }
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        originStack.pop();
        minStack.pop();
    }

    public int top() {
        return originStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
