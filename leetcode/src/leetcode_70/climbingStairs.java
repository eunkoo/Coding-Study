package leetcode_70;

public class climbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s =new Solution();
		int ret =s.climbStairs(4);
		System.out.println(ret);
	}

}
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        int ret = helper(n,dp,0);
        return ret;
    }
    int helper(int n, int[] dp, int step ){
        if(step == n)   return 1;
        else if(step > n) return 0;
        
        if(dp[step] != 0)
            return dp[step];
        dp[step] = helper(n,dp,step+1) + helper(n,dp,step+2);
        return dp[step];
    }
}