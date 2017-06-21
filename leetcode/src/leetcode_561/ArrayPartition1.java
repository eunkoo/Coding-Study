package leetcode_561;

import java.util.Arrays;

public class ArrayPartition1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.arrayPairSum(new int[]{1,2,3,4});
		System.out.println(ret);
	}

}
class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0;i<nums.length;i=i+2){
            sum += nums[i];
        }
        return sum;
    }
}