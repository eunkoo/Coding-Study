package leetcode_263;

public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s =new Solution();
		boolean ret = s.isUgly(60);
		System.out.println(ret);
	}

}
class Solution {
    public boolean isUgly(int num) {
        if(num==0) return false;
        while(num%2==0) num/=2;
        while(num%3==0) num/=3;
        while(num%5==0) num/=5;
        return num == 1;
    }
}