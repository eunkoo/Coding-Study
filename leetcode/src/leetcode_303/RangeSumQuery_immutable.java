package leetcode_303;

public class RangeSumQuery_immutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumArray na = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
		int param_1 = na.sumRange(0,2);
		System.out.println(param_1);
		int param_2 = na.sumRange(2,5);
		System.out.println(param_2);
		int param_3 = na.sumRange(0,5);
		System.out.println(param_3);
	}

}
class NumArray {

	   // int[] m_nums = null;
	    int[] dp = null;
	    public NumArray(int[] nums) {
	       if(nums == null || nums.length == 0) return;
	        dp = new int[nums.length];
	        dp[0] = nums[0];
	        for(int i =1;i<nums.length;i++)
	            dp[i] = dp[i-1] + nums[i];
	     }
	    
	    public int sumRange(int i, int j) {
	        if(dp == null) return 0;
	        int res = 0;
	        if(i == 0) res = dp[j];
	        else{
	            //System.out.println("dp[j] : "+dp[j]+" dp[i-1]:"+dp[i-1]);
	            res = dp[j] - dp[i-1];
	        }
	        return res;
	    }
	}

	/**
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * int param_1 = obj.sumRange(i,j);
	 */