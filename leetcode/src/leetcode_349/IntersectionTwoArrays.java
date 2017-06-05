package leetcode_349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[]ret = s.intersection(new int[] {1, 2, 2, 1}, new int[]{2,2});
		for(int x : ret)
			System.out.println(x);
	}

}
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length ==0 || nums2==null||nums2.length==0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        // int size = Math.max(len1,len2);
        Set<Integer> set = new HashSet<>();
        int i=0,j=0;
        while(i<len1 && j<len2){
            if(nums1[i] == nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] result = new int[set.size()];
        int c = 0;
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()){
            result[c++] = iter.next();
        }
        return result;
    }
}