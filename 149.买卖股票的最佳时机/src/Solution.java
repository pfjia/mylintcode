/**
 * Created by pfjia on 2017/5/8 0008.
 */
public class Solution {
	/**
	 * @param prices: Given an integer array
	 * @return: Maximum profit
	 */
	public int maxProfit(int[] prices) {
		// write your code here
		if (prices.length==0){
			return 0;
		}
		int profit_ending_here=0;
		int maxProfit=0;
		for(int i=1;i< prices.length;i++){
			if(profit_ending_here>0){
				profit_ending_here=profit_ending_here+prices[i]-prices[i-1];
			}else {
				profit_ending_here=prices[i]-prices[i-1];
			}
			maxProfit=Math.max(maxProfit,profit_ending_here);
		}
		return maxProfit;
	}
}