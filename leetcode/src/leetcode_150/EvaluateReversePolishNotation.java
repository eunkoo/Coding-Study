package leetcode_150;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.evalRPN(new String[]{"2", "1", "+", "3", "*"});
		System.out.println(ret);
	}

}
class Solution {
    public int evalRPN(String[] tokens) {
        String oper = "+-*/";
        int res = 0;
        if(tokens == null || tokens.length == 0) return res;
        Stack<String> stack = new Stack<String>();
        for(String t : tokens){
            if(oper.contains(t)){
                int n1 = Integer.parseInt(stack.pop());
                int n2 = Integer.parseInt(stack.pop());
                int calc = t.equals("+") ? n1+n2 :
                            t.equals("-") ? n2-n1 :
                            t.equals("*") ? n1*n2 :
                            n2/n1 ;
                
                stack.push(calc+"");
            }else
                stack.push(t);
        }
        return Integer.parseInt(stack.pop());
    }
}
