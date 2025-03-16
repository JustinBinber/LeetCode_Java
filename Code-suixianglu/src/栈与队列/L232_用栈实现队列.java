package 栈与队列;

import java.util.Stack;

public class L232_用栈实现队列 {

    class MyQueue {

        Stack<Integer> stackin = new Stack<>();
        Stack<Integer> stackout = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            stackin.add(x);
        }

        public int pop() {
            if (stackout.isEmpty()){
                while (!stackin.isEmpty()){
                    stackout.add(stackin.pop());
                }
            }
            return stackout.pop();
        }

        public int peek() {
            if (stackout.isEmpty()){
                while (!stackin.isEmpty()){
                    stackout.add(stackin.pop());
                }
            }
            return stackout.peek();
        }

        public boolean empty() {
            return stackout.isEmpty() && stackin.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
