package leetcode_599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinIdxSumOfTwoList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[] ret = s.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, 
				new String[]{"KFC", "Shogun", "Burger King"});
		for(String str : ret){
			System.out.println(str);
		}

	}

}
 class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i =0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        List<String> res = new ArrayList<>();
        int min_idx = Integer.MAX_VALUE;
        for(int j=0;j<list2.length;j++){
            if(map.containsKey(list2[j]) ){
                if(min_idx > (map.get(list2[j]) + j)){
                    min_idx = map.get(list2[j])  + j;
                    res.clear();
                    res.add(list2[j]);
                }else if(min_idx == (map.get(list2[j]) + j)){
                    res.add(list2[j]);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}