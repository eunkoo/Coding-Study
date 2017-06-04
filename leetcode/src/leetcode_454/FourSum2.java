package leetcode_454;

import java.util.HashMap;

public class FourSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret =s.fourSumCount( new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2});
		System.out.println(ret);
	}

}
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length ==0) return 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int a : A){
            for(int b : B){
                int sum = a+b;
                map.put( sum, map.getOrDefault(sum,0)+1);
            }
        }
        int count = 0;
        for(int c : C){
            for(int d : D){
                int sum = c+d;
                count += map.getOrDefault(-1*sum,0);
            }
        }
        return count;
    }
}