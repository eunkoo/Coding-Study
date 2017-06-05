package leetcode_69;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.mySqrt(39);
		System.out.println(ret);;

	}

}
class Solution {
    public int mySqrt(int x) {
        if(x==1) return x;
        long l=1,h=x,m=0,ans=0;
        while(l<=h){
            m = l+(h-l)/2;
            if(m <= x/m){
                l = m+1;
                ans=m;
            }else{
                h = m-1;
            }
        }
        return (int)ans;
    }
}