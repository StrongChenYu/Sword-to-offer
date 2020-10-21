package sword_to_offer;


import java.util.Stack;

//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
public class JZ20 {

    private Stack<Integer> stackAll = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        stackAll.push(node);
        if (stackMin.isEmpty() || stackMin.peek() > node) {
            stackMin.push(node);
        } else {
            stackMin.push(stackMin.peek());
        }
    }

    public void pop() {
        stackAll.pop();
        stackMin.pop();
    }

    public int top() {
        return stackAll.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
