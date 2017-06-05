package leetcode_441;

public class ArrangingCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.arrangeCoins(5);
		System.out.println(ret);
	}

}
class Solution {
    public int arrangeCoins(int n) {
        int k =n,count=1;
        while(k>0){
            k -= count;
            count++;
        }
        count--;
        if(k<0) count--;
        return count;
    }
}