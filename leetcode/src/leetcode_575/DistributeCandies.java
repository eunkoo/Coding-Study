package leetcode_575;

import java.util.Arrays;

public class DistributeCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.distributeCandies(new int[]{1,1,2,2,3,3});
		System.out.println(ret);
	}

}
class Solution {
    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int nkind=1;
        for(int i=1;i<candies.length;i++){
            if(candies[i-1]!=candies[i]){
                nkind++;
            }
        }
        return candies.length/2 <= nkind? candies.length/2 : nkind;
    }
}