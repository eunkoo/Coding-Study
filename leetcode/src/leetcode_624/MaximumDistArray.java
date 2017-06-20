package leetcode_624;

import java.util.ArrayList;
import java.util.List;

public class MaximumDistArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		
	}

}
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min1 =  Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        int mi1 =0;
        int max1 = Integer.MIN_VALUE,max2=Integer.MIN_VALUE;
        int ma1=0;
        
        for(int i=0;i<arrays.size();i++){
            List<Integer> lst = arrays.get(i);
            if(min1 > lst.get(0)){
                min2 = min1;
                min1 = lst.get(0);
                mi1 = i;
            }else if(min2 > lst.get(0)){
                min2=lst.get(0);
            }
            if(max1 < lst.get(lst.size()-1)){
                max2 = max1;
                max1 = lst.get(lst.size()-1);
                ma1=i;
            }else if(max2 < lst.get(lst.size()-1)){
                max2 = lst.get(lst.size()-1);
            }
        }
        if(mi1==ma1){
            return Math.max(max2-min1,max1-min2);
        }else{
            return max1-min1;
        }
    }
}
