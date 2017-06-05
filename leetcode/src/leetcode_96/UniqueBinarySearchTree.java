package leetcode_96;

public class UniqueBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.numTrees(4);
		System.out.println(ret);
	}

}
class Solution {
    public int numTrees(int n) {
       int[] dp = new int[n+1];
       
       dp[0]=dp[1]=1;
       
       for(int i=2;i<=n;i++){
           for(int j=1;j<=i;j++){
               dp[i] += dp[j-1]*dp[i-j];
           }
       }
       return dp[n];
    }
  
    
}