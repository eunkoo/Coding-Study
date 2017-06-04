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
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length, buy = 0,sell =0, res = 0;
        for(int i=0;i<len;i++){
            buy = prices[buy] > prices[i] ? i : buy;
            if(i > buy){
                sell =  prices[i] > prices[buy]  ? i : sell;
            if(sell > buy)
                res = Math.max(res, prices[sell] - prices[buy]);
               //System.out.println("res "+res+" i "+i+" buy "+buy+" sell "+sell);
            }
        }
        return res;
        
    }
}