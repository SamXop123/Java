// Stack using single queue

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue {
    Queue<Integer> q;

    public StackUsingQueue() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        int size = q.size();
        for (int i = 0; i < size-1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.remove();
    }

    public int top() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.peek();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

  
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped: " + stack.pop());

        System.out.println("Top element after pop: " + stack.top());
    }
}
