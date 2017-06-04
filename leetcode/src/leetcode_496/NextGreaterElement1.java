package leetcode_496;

import java.util.Arrays;

public class NextGreaterElement1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] ret = s.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
		for(int x : ret)
			System.out.println(x);
	}

}
class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if(findNums == null || findNums.length == 0 || nums == null || nums.length==0) return new int[0];
        int nLen = nums.length, fLen = findNums.length;
        int[] res = new int[fLen];
        Arrays.fill(res,-1);
        int i =0,j=0;
        while(i<fLen && j < nLen){
            if(findNums[i] == nums[j]){
                int fast = j+1;
                while(fast < nLen){
                    if(nums[j] < nums[fast] ){
                        res[i] = nums[fast] ;
                        break;
                    }else{
                        fast++;
                    }
                }
                i++;
                j=-1;
            }
            j++;
            
        }
        return res;
    }
}