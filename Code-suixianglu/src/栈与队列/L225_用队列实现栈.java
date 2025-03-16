package 栈与队列;

import java.util.LinkedList;
import java.util.Queue;

public class L225_用队列实现栈 {
    class MyStack {

        Queue<Integer> queue;
        public MyStack() {
            queue = new LinkedList<Integer>();
        }

        public void push(int x) {
            int size = queue.size();
            queue.add(x);
            for (int i = 0; i <= size - 1; i++) {
                int tem;
                tem = queue.poll();
                queue.add(tem);
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
