package leetcode_542;

import java.util.LinkedList;
import java.util.Queue;

public class ZOMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[][] ret = s.updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
		for(int[] row: ret){
			for(int cell : row)
				System.out.print(cell);
			System.out.println();
		}
	}

}
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0) return matrix;
        int R = matrix.length;
        int C  = matrix[0].length;
        Queue<int[]> quZero = new LinkedList<>();
        int[][] dirs = new int[][]{{-1,0},{0,-1},{0,1},{1,0}}; 
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                if(matrix[i][j]==1) matrix[i][j] = Integer.MAX_VALUE;
                else    quZero.add(new int[]{i,j});
        while(!quZero.isEmpty()){
            int[] curr = quZero.poll();
            int cRow = curr[0], cCol = curr[1];
            for(int[] dir : dirs){
                int r = cRow + dir[0];
                int c = cCol + dir[1];
                if(r < 0 || r >=R || c <0 || c>=C
                || matrix[r][c]==0) continue;
                if(matrix[r][c]==Integer.MAX_VALUE) quZero.add(new int[]{r,c});
                matrix[r][c] = Math.min(matrix[r][c], matrix[cRow][cCol]+1);
            }
        }
       return matrix;
    }
}