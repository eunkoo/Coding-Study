package leetcode_121;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
		System.out.println(ret);
	}

}
class Solution {
    public int maxProfit(int[] prices) {
 
	if(prices.length<2) return 0;
        int buy = prices[0];
        int max_pro = Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
            if(buy > prices[i]){
                buy = prices[i];
                continue;
            }
            int c_pro = prices[i] - buy;
            max_pro = Math.max(max_pro,c_pro);
        }
        return max_pro < 0 ? 0 : max_pro;
        }
        return res;
        
    }
}
