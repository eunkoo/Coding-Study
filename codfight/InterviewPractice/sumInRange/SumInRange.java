package sumInRange;

import java.math.BigInteger;

public class SumInRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.sumInRange(new int[]{3, 0, -2, 6, -3, 2}, new int[][]{{0,2},{2,5},{0,5}});
		System.out.println(ret);
		
	}

}
class Solution{
	int sumInRange(int[] nums, int[][] queries) {
	    int len = nums.length;
	    int[] dp = new int[len+1];
	    dp[0] = nums[0];
	    for(int i=1;i<len;i++){
	        dp[i] = dp[i-1] + nums[i];
	    }
	    double sum =0;
	    for(int[] pair : queries){
	         int s = pair[0] == 0 ? 0 :dp[pair[0]-1] ;
	         int e = dp[pair[1]] ;
	        sum += e - s;
	    }
	    long mod = (long)Math.pow(10,9)+7;
	    long r = (long) (Math.abs(sum)%mod);
	    if(sum==r) return (int)sum;
	    return (int)(mod - r);
	    
	}
}