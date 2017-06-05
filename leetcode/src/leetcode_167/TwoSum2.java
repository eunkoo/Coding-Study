package leetcode_167;

import java.util.HashSet;

public class TwoSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] ret = s.twoSum(new int[]{2, 7, 11, 15}, 9);
		for(int x : ret)
			System.out.println(x);
	}

}
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<numbers.length;i++){
            if(set.contains(numbers[i])) continue;
            set.add(numbers[i]);
            int num = target - numbers[i];
            int l=i+1,h=numbers.length-1, mid = l+(h-l)/2;
            //System.out.println("num:"+num+" l:"+l+" h:"+h+" mid:"+mid);
            while(l<=h){
                mid = l+(h-l)/2;
                if(num == numbers[mid]){
                    result[0]=i+1;
                    result[1]=mid+1;
                    return result;
                }else if(num < numbers[mid]){
                    h = mid-1;
                }else{
                    l = mid+1;
                }
            }
        }
        
        return result;
    }
}