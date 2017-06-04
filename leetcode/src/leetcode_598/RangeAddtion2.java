package leetcode_598;

public class RangeAddtion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.maxCount(3, 3, new int[][]{{2,2},{3,3}});
		System.out.println(ret);
	}

}
 class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        
        if(m==0 && n==0 ) return 0;
        if(ops.length==0 || ops[0].length==0) return m*n;
        
        //int[][] tar = new int[m][n];
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        
        for(int i=0;i<ops.length;i++){
            int [] pnt = ops[i];
            minRow = Math.min(minRow, pnt[0]);
            minCol = Math.min(minCol, pnt[1]);
             
        }
        return minRow*minCol;
    }
}