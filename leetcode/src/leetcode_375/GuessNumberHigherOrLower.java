package leetcode_375;

public class GuessNumberHigherOrLower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.getMoneyAmount(8);
		System.out.println(ret);
	}

}
class Solution {
    int[][] dp = null;
    public int getMoneyAmount(int n) {
        if(n ==0) return 0;
        dp = new int[n+1][n+1];
        
        
        return getMinAmount(1,n);
        
    }
    
    int  getMinAmount(int l, int h){
        //System.out.println("low:"+l+"high:"+h);
        if(l >= h)   return 0;
        int res = dp[l][h];
        if(res!=0) return res;
        if(l+2==h){
            res = l+1;
        }else if(l+1==h){
            res= l;
        }else{
            res = Integer.MAX_VALUE;
            for(int i=l+1;i<h;i++){
                int c = Math.max(getMinAmount(l,i-1) + i,i + getMinAmount(i+1,h) );
                res = Math.min(res,c);
            }
        }
        dp[l][h] = res;
        //System.out.println("res : "+res);
        return res;
    }
}