package sumofTwo;

import java.util.HashMap;

public class SumofTwo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		boolean ret = s.sumOfTwo(new int[]{1,2,3}, new int[]{10, 20, 30, 40},42);
		System.out.println(ret);
	}
}

class Solution{
	boolean sumOfTwo(int[] a, int[] b, int v) {
	    HashMap<Integer, Boolean> map = new HashMap<>();
	    for(int an : a)
	        map.put(v-an,true);
	    boolean res = false;
	    for(int bn:b){
	        res |= map.containsKey(bn);
	        //System.out.println("res : "+res);
	    }
	    return res;
	}
}