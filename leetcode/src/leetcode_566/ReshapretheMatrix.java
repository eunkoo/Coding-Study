package leetcode_566;

public class ReshapretheMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int [][] ret = s.matrixReshape(new int[][]{{1,2},{3,4}}, 4, 1);
		for(int i=0;i<ret.length;i++){
			for(int j=0;j<ret[0].length;j++){
				System.out.print(ret[i][j]);
			}
			System.out.println();
		}
	}

}

 class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] newNums = new int[r][c];
        int pC = nums[0].length, pR = nums.length;
        if(pC*pR != r*c) return nums;
        for(int i=0;i<pC * pR;i++){
            newNums[i/c][i%c] = nums[i/pC][i%pC];
        }
        return newNums;
    }
}