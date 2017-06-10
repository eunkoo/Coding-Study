package leetcode_231;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PowerOf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		boolean b = s.isPowerOfTwo(64);
		System.out.println(b);
	}

}
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        
        while(n>1){
            if(n%2!=0) return false;
            n/=2;
        }
        return true;
    }
    
   
}