package leetcode_342;

public class PowerOf4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		boolean ret = s.isPowerOfFour(64);
		System.out.println(ret);
	}

}
class Solution {
    public boolean isPowerOfFour(int num) {
        if(num ==1)return true;
        if(num <4 || num%4!=0) return false;
        int i=1,tar=0,j=2;
        while(num > 4){
            if((num/4)%4!=0)return false;
            num/=4;
        }
        return true;
    }
}