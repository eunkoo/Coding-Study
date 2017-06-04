package leetcode_503;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] ret = s.nextGreaterElements(new int[]{1,2,1});
		for(int x : ret)
			System.out.println(x);
	}

}
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0)    return new int[0];
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res, -1);
        for(int i=0;i<len*2;i++){
            int num = nums[i%len];
            while(!stack.isEmpty() && nums[stack.peek()] < num)
                res[stack.pop()] = num;
            if(i < len)
                stack.push(i);
        }
        
        return res;
    }
}