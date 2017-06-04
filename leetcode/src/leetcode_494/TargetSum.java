package leetcode_494;

public class TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
		System.out.println(ret);
	}
	
}
/*
 *
1. The length of the given array is positive and will not exceed 20.
2. The sum of elements in the given array will not exceed 1000.
3. Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
class Solution {
	int dp[][];
	 int target = 0;
	    public int findTargetSumWays(int[] nums, int S) {
	        dp = new int[20][2000];
	        target = S;
	        int res = helper(nums,0,1000);
	        return res;
	    }
	    int helper(int[] nums, int idx, int sum){
	        //System.out.println(sum);
	        if(idx == nums.length){
	            if(sum-1000 == target) return 1;
	            else    return 0;
	        }
	        //if(sum >= target) return 0;
	        int cnt = helper(nums,idx+1,sum+nums[idx]);
	        //System.out.println("sum1 "+cnt);
	        cnt += helper(nums,idx+1,sum-nums[idx]);
	        //System.out.println("sum2 "+cnt);
	        return cnt;
	    }
	}