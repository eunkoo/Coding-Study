package leetcode_225;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  MyStack obj = new MyStack();
		  obj.push(5);
		  
		  int param_3 = obj.top();
		  System.out.println(param_3);
		  int param_2 = obj.pop();
		  System.out.println(param_2);
		  boolean param_4 = obj.empty();
		  System.out.println(param_4);
	}

}
class MyStack {

    Queue<Integer> qu = null;
    int t = -1;
    /** Initialize your data structure here. */
    public MyStack() {
        qu = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        qu.offer(x);
        t = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> tmp = new LinkedList<>();
        if(qu.size() == 1) {
            t = -1;
            return qu.poll();
        }
        while(qu.size() != 1){
            t = qu.poll();
            tmp.offer(t);
        }
        int res = qu.poll();
        qu = tmp;
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        return t;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return qu.isEmpty();
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