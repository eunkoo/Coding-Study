package leetcode_529;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MineSweeper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[] b = new String[]{"EEEEE","EEMEE","EEEEE","EEEEE"};
		
		char[][] board = new char[b.length][];
		for(int i=0;i<b.length;i++){
			String str = b[i];
			board[i] = str.toCharArray();
		}
		char[][] ret = s.updateBoard(board, new int[]{3,2});
		for(char[] row : ret){
			for(char cell : row){
				System.out.print(cell);
			}
			System.out.println();
		}
	}

}
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board.length==0) return board;
        int R = board.length, C = board[0].length;
        Queue<int[]> eCells = new LinkedList<>();
       
        int[][] dir = new int[][]{{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
        eCells.add(click);
        while(!eCells.isEmpty()){
            int[] pnt = eCells.poll();
            int r = pnt[0], c =pnt[1];
            if(board[r][c]=='M' ){
                board[r][c]='X';
                break;
            }
            List<int[]> candCells = new ArrayList<>();
            int countOfMine = 0;
            for(int[] d : dir){
                if(r+d[0]>=R || r+d[0]<0 || c+d[1] >=C || c+d[1]<0) continue;
                
                if(board[r+d[0]][c+d[1]] == 'M'||board[r+d[0]][c+d[1]] == 'X') 
                    countOfMine++;
                else if(board[r+d[0]][c+d[1]] == 'E'){
                    candCells.add(new int[]{r+d[0],c+d[1]});
                }
            }
            if(countOfMine > 0) {
                board[r][c] = (char)(48+countOfMine);
                continue;
            }else if( board[r][c] == 'E'){
                board[r][c] = 'B';
                for(int[] cell : candCells)
                    eCells.add(cell);
            }
            
            
        }
        return board;
       
    }
}