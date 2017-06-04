package leetcode_309;

public class BestTimetoBuyandSellStockwithCooltime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.maxProfit(new int[]{1, 2, 3, 0, 2});
		System.out.println(ret);
	}

}
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0) return 0;
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        int[] rest = new int[len];
        
        buy[0] = -prices[0];
        sell[0] = 0;
        rest[0] = 0;
        for(int i=1;i<len;i++){
            buy[i] = Math.max(buy[i-1], rest[i-1]-prices[i]);
            rest[i] = Math.max(rest[i-1],sell[i-1]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
        }
        return sell[len-1];
    }
}