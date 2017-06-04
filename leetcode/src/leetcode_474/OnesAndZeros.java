package leetcode_474;

public class OnesAndZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
		System.out.println(ret);
	}

}
class Solution {
    int[][][] dp = null;
   // int[][] dp = null;
    
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length == 0) return 0;
        int len = strs.length;
        dp = new int[len][m+1][n+1];
       //dp = new int[len];
        int[][] input= new int[len][2];
        for(int i=0;i<len;i++){
            String s = strs[i];
            for(char c :s.toCharArray()){
                if( c=='0') input[i][0]++;
                else input[i][1]++;
            }
        }
        
        // for(int i=0;i<len;i++)
        //      for(int j =0;j<m;j++)
        //          for(int k=0;k<n;k++)
        //             dp[i][j][k] = -1;
                    
         return findMax(input,0, m,n);
         
    }
    int findMax(int[][] input,int i,int remainX, int remainY){
        //System.out.println(i+" "+remainX+" "+remainY);
        
        //if(remainX < 0 || remainY < 0) return -1;
        if((i == input.length)  || (remainX + remainY == 0)) return 0;
        //System.out.println(input[i][0]+" "+input[i][1]);
        
        int ret = dp[i][remainX][remainY] ;
        if(ret > 0) return ret;
       // for(int i=idx;i<input.length;i++)
       // {
        int tem = 0;
        if (remainX-input[i][0] >= 0 && remainY-input[i][1] >= 0){//i++;//continue;
            ret = Math.max( findMax(input,i+1,remainX,remainY), findMax(input,i+1,remainX-input[i][0],remainY-input[i][1])+1);
        }else
            tem = findMax(input,i+1,remainX,remainY);
        ret = Math.max(ret,tem);
           
        dp[i][remainX][remainY] = ret;
        //dp[i]=ret;
        //System.out.println("ret : " + ret);
        return dp[i][remainX][remainY] ;
    }
}