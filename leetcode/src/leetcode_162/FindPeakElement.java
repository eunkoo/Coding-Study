package leetcode_162;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.findPeakElement(new int[]{1,2,5,6,4,3,44});
		System.out.println(ret);

	}

}
class Solution {
    public int findPeakElement(int[] nums) {
        int max = Integer.MIN_VALUE, idx = -1;
        if(nums == null || nums.length==0) return 0;
        for(int i=0;i<nums.length;i++){
            if(max <= nums[i]){
                idx = i;
                max = nums[i];
            }
        }
        return idx;
    }
}