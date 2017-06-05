package leetcode_367;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		boolean ret = s.isPerfectSquare(16);
		System.out.println(ret);
		
	}

}
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            //System.out.println(mid);
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
 }