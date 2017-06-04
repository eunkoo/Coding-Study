package leetcode_300;

public class LognestIncreaseSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
		System.out.println(ret);
	}

}
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int maxCount = 0;
        int[] dp = new int[nums.length];
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxCount = Math.max(maxCount,dp[i]);
        }
        
        return maxCount+1;
    }
}