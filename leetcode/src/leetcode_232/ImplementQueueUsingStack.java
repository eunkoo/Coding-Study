package leetcode_232;

import java.util.Stack;

public class ImplementQueueUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue obj = new MyQueue();
		 obj.push(3);
		 int param_3 = obj.peek();
		 System.out.println(param_3);

		 int param_2 = obj.pop();
		 System.out.println(param_2);
		 
		 boolean param_4 = obj.empty();
		 System.out.println(param_4);
	}

}
 class MyQueue {

    Stack<Integer> stack = null;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        Stack<Integer> tmp = new Stack<>();
      
        while(!stack.isEmpty())
            tmp.push(stack.pop());
        tmp.push(x);
        while(!tmp.isEmpty())
            stack.push(tmp.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
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