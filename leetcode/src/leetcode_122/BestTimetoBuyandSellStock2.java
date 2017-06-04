package leetcode_122;

public class BestTimetoBuyandSellStock2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int ret = s.maxProfit(new int[]{3,5,2,2,5,9});
		System.out.println(ret);
	}

}
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0) return 0;
        int len = prices.length, res = 0;
        int[] buy = new int[len];
        int[] sell = new int[len];
         buy[0] = -prices[0];
         sell[0] = 0;
        //sell[1] = Math.max(0,prices[1]-prices[0]);
        for(int i=1;i<len;i++){
            buy[i] = Math.max(sell[i-1] - prices[i], buy[i-1]);
            sell[i] =Math.max( buy[i-1] + prices[i], sell[i-1]);
        }
        return sell[len-1];
    }
}