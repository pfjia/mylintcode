/**
 * Created by pfjia on 2017/5/8 0008.
 */
public class Solution {
	/**
	 * @param prices:
	 *            Given an integer array
	 * @return: Maximum profit
	 */
	public int maxProfit(int[] prices) {
		// write your code here
		if (prices.length == 0) {
			return 0;
		}
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			// 买卖次数无限，只要可以获利就买卖
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] prices = { 2, 1, 2, 0, 1 };
		int profit = s.maxProfit(prices);
		System.out.println(profit);
	}
}