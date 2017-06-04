package leetcode_486;

public class PredictWinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		boolean ret = s.PredictTheWinner(new int[]{1, 5, 233, 7});
		System.out.println(ret);
	}

}
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;

        int[][] p1 = new int[n][n];
        for(int k=0;k<n;k++)  p1[k][k] = nums[k];
 
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                    p1[i][j] = Math.max(nums[i] -p1[i+1][j], nums[j] - p1[i][j-1]);
            }
        }

       return p1[0][n-1] >= 0;
    }
}