package leetcode_350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] ret = s.intersect(new int[]{1,2,2,1},new int[]{2,2});
		for(int x : ret)
			System.out.println(x);
	}

}
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length==0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        
        List<Integer> result = new ArrayList<>();
        int i=0,j=0;
        while(i<len1 && j<len2){
            int n1 = nums1[i];
            int n2 = nums2[j];
            if(n1 == n2){
                result.add(n1);
                i++;
                j++;
            }else if(n1 < n2){
                i++;
            }else{
                j++;
            }
        }
        
        int[] r = new int[result.size()];
        for(int k=0;k<result.size();k++)
            r[k] = result.get(k);
            
        return r;
    }
}