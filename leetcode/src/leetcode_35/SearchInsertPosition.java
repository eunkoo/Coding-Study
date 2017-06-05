package leetcode_35;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.searchInsert(new int[]{1,3,5,6}, 5);
		System.out.println(ret);;
	}

}
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length ==0) return 0;
        int len = nums.length;
        if(nums[0] > target) return 0;
        if(nums[len-1] < target) return len;
        
        int l=0,h=len-1,m=0;
        while(l<h){
            m = l+(h-l)/2;
            if(nums[m] == target){
                return m;
            }else if(nums[m] < target){
                l = m+1;
            }else{
                h = m;
            }
        }
        return l+(h-l)/2;
    }
}