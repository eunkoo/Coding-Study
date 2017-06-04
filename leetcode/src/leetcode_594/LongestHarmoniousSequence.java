package leetcode_594;

import java.util.Arrays;

public class LongestHarmoniousSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.findLHS(new int[]{1,3,2,2,5,2,3,7});
		System.out.println(ret);

	}

}
class Solution {
    public int findLHS(int[] nums) {
        if(nums.length ==0) return 0;
        int l=0,r=0, max=0;
        Arrays.sort(nums);
        while(r < nums.length){
            if(nums[r] - nums[l] == 1) 
                max = Integer.max(max, r-l+1);
                
                if(nums[r] - nums[l] > 1){
                    l++;
                }else {
                    r++;
                }
            
        }
        return max;
    }
}
