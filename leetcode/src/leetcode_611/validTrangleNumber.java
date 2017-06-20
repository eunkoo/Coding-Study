package leetcode_611;

import java.util.Arrays;

public class validTrangleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s =new Solution();
		int ret = s.triangleNumber(new int[]{2,2,3,4});
		System.out.println(ret);
	}

}
class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length<3) return 0;
        Arrays.sort(nums);
        int cnt=0;
        for(int i=0;i<nums.length-2;i++){
            int k=i+1;
            for(int j=i+1;j<nums.length-1;j++){
                while(k<nums.length && nums[i]+nums[j]>nums[k]){
                    k++;
                }
                if(j<k)     cnt+=k-j-1;
            }
        }
        return cnt;
    }
}