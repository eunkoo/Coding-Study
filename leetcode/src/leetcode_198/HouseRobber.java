package leetcode_198;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.rob(new int[]{2,1,1,2});
		System.out.println(ret);
	}

}
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int[] get = new int[nums.length];
        int[] skip = new int[nums.length];
        get[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            get[i] = skip[i-1]+nums[i];
            skip[i] = Math.max(skip[i-1], get[i-1]);
        }
        return Math.max(get[nums.length-1],skip[nums.length-1]);
    }
    
}