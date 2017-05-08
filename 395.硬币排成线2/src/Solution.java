/**
 * Created by pfjia on 2017/5/8 0008.
 */
public class Solution {
	/**
	 * @param values:
	 *            an array of integers
	 * @return: a boolean which equals to true if the first player will win
	 */
	public boolean firstWillWin(int[] values) {
		// write your code here
		if (values.length <= 2) {
			return true;
		}

		int[] dp = new int[values.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = Integer.MIN_VALUE;
		}
		if (aux(values, dp, 0) > aux(values, dp, 1)
				|| aux(values, dp, 0) > aux(values, dp, 2)) {
			return true;
		}
		return false;
	}

	/**
	 * 表示从i到end能取到的最大值
	 *
	 * @param values
	 * @param i
	 * @return
	 */
	public int aux(int[] values, int[] dp, int i) {
		if (dp[i] != Integer.MIN_VALUE) {
			return dp[i];
		}

		int length = values.length;
		if (i == length - 1) {
			return values[i];
		} else if (i == length - 2) {
			return values[i] + values[i + 1];
		} else if (i == length - 3) {
			return values[i] + values[i + 1];
		} else if (i == length - 4) {
			return Math.max(values[i] + values[i + 1],
					values[i] + values[i + 3]);
		}

		// 我们在i处有两种选择1.选择i，2.选择i和i+1
		// 如果选择i
		int selection1 = values[i]
				+ Math.min(aux(values, dp, i + 2), aux(values, dp, i + 3));
		int selection2 = values[i] + values[i + 1]
				+ Math.min(aux(values, dp, i + 3), aux(values, dp, i + 4));
		return Math.max(selection1, selection2);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] prices = { 16, 27, 25, 23, 25, 16, 12, 9, 1, 2, 7, 20, 19, 23, 16,
				0, 6, 22, 16, 11, 8, 27, 9, 2, 20, 2, 13, 7, 25, 29, 12, 12, 18,
				29, 27, 13, 16, 1, 22, 9, 3, 21, 29, 14, 7, 8, 14, 5, 0, 23, 16,
				1, 20 };
		System.out.println(s.firstWillWin(prices));
	}
}