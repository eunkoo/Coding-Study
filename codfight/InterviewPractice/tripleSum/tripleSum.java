package tripleSum;

import java.util.Arrays;

public class tripleSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution s = new solution();
		boolean ret = s.tripletSum(15, new int[]{14, 1, 2, 3, 8, 15, 3});
		System.out.println(ret);
	}
	
}
class solution{
	boolean tripletSum(int x, int[] a) {
	    Arrays.sort(a);
	    if(a == null || a.length == 0) return false;
	    int len = a.length;
	    
	    for(int i=0;i<len;i++){
	        int s = i+1, e = len-1;
	        while(s < e){
	            if(a[i]+a[s]+a[e] == x) return true;
	            else if(a[i]+a[s]+a[e] > x)
	                e--;
	            else
	                s++;
	        }
	    }
	   

	    return false;
	    
	}
}
