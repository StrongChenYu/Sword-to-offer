package sword_to_offer;

import java.util.Stack;

/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class JZ5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
//stupid function!!!!!
//    public void push(int node) {
//        stack1.push(node);
//    }
//
//    public int pop() {
//        while (!stack1.isEmpty()) {
//            stack2.push(stack1.pop());
//        }
//
//        int ret = stack2.pop();
//
//        while (!stack2.isEmpty()) {
//            stack1.push(stack2.pop());
//        }
//
//        return ret;
//    }
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }

        return stack2.pop();
    }
}
