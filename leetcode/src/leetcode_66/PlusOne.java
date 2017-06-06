package leetcode_66;

import java.util.ArrayList;


public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s =new Solution();
		int[] ret = s.plusOne(new int[]{9,9,9});
		for(int x :ret)
			System.out.println(x);
	}

}
class Solution {
    public int[] plusOne(int[] digits) {
        int up = 0, len = digits.length,sum=0;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i =len-1;i>=0;i--){
        	
            if(i==len-1){
              sum = (digits[i] + 1)%10;
              up =  (digits[i] + 1)/10;
            }else{
              sum = (digits[i] + up)%10;
              up =  (digits[i] + up)/10; 
            }
            ret.add(0,sum);
        }
        if(up!=0)ret.add(0,up);
        int[] r = new int[ret.size()];
        for(int i=0;i<ret.size();i++)
            r[i] = ret.get(i);
            
        return  r;
    }
}