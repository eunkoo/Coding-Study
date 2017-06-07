package leetcode_27;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.removeElement(new int[]{2,3,4,2},2);
		System.out.println(ret);
	}

}
class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int count = 0;
        for(int i=len-1;i>=0;i--){
            if(nums[i]==val){
                for(int j=i;j<len-1;j++){
                    nums[j] = nums[j+1];
                }
                count++;
            }
        }
        return len - count;
    }
}