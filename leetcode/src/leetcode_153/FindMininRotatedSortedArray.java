package leetcode_153;

public class FindMininRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.findMin(new int[]{0, 1, 2, 4, 5, 6, 7});
		System.out.println(ret);
	}

}
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int len = nums.length,fval = nums[0],lval = nums[len-1];
        if(fval <= lval) return nums[0];
        int l =0 , h = len-1, m1 = l,m2 = h;
        
        while(l <=  h){
            m1 = (l+h)/2;
            m2 = m1+1;
            if(nums[m2] < nums[m1]){
                return nums[m2];
            }
            else if(fval <= nums[m1] ){
               l = m2;
            }else if(nums[m2] <= lval )
            {
                h = m1;
            }else{
               break;
            }
        }
        return nums[l];
    }
}