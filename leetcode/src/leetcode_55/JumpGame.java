package leetcode_55;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		boolean ret = s.canJump(new int[]{2,3,1,1,4});
		System.out.println(ret);
	}

}
class Solution {
	boolean[] p = null;
public  boolean canJump(int[] nums) {
   if(nums == null | nums.length<=1) return true;
   boolean res = true;
   
   int len = nums.length, max = -1;
   for(int i=0;i<len-1;i++){
	   if((0==nums[i]) && (max<=i)) return false;
	   max = Math.max(max, nums[i]+i);
   }
   return res;
} 
}