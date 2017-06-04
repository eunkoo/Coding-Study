package leetcode_20;

import java.util.Stack;

public class ValidParatheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		boolean ret =  s.isValid("{df}()[{}]");
		System.out.println(ret);
	}

}
class Solution {
    public boolean isValid(String s) {
        boolean res = true;
        if(s == null | s.length() == 0) return res;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '[')    stack.push(']');
            else if(c == '{') stack.push('}');
            else if(c == '(') stack.push(')');
            else if((c == ')' ) 
            || (c == '}' ) 
            || (c == ']' )){
                if(stack.isEmpty() || c != stack.pop())
                    res = false;
                
            } 
            
            if(!res) break;
        }
        
        return res && stack.size() == 0;
    }
}