package leetcode_53;

public class MaxSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
		System.out.println(ret);;

	}

}
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length, res = Integer.MIN_VALUE;
        
        int[] dp = new int[len];
        res = dp[0] = nums[0];
        for(int i=1;i< len;i++){
            dp[i]  = Math.max(dp[i-1] + nums[i], nums[i]);    
            res = Math.max(res , dp[i]);
        }
        return res;
    }
}