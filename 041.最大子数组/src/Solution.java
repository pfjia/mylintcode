public class Solution {
	/**
	 * @param nums
	 *            : A list of integers
	 * @return: A integer indicate the sum of max subarray
	 */
	/**
	 * 暴力穷举法，每一个循环计算从i到最后一个元素的最长连续子数组元素和
	 * 
	 * @param nums
	 * @return
	 */
	// public int maxSubArray(int[] nums) {
	// // write your code
	// int maxVal = Integer.MIN_VALUE;
	// for (int i = 0; i < nums.length; i++) {
	// // 每一个循环计算从i到最后一个元素的最长连续子数组元素和
	// int sum = 0;
	// for (int j = i; j < nums.length; j++) {
	// sum += nums[j];
	// maxVal = maxVal > sum ? maxVal : sum;
	// }
	// }
	// return maxVal;
	// }

	/**
	 * 分治法
	 *
	 * 1、完全位于左边的数组中。
	 * 
	 * 2、完全位于右边的数组中。
	 * 
	 * 3、跨越中点，包含左右数组中靠近中点的部分。
	 * 
	 * @param nums
	 * @return
	 */

	public int maxSubArray(int[] nums) {
		// write your code
		return aux(nums, 0, nums.length);
	}

	/**
	 * 返回[begin,end)中元素的最大子数组
	 * 
	 * @param nums
	 * @param begin
	 * @param end
	 * @return
	 */
	public int aux(int[] nums, int begin, int end) {
		int maxLeft = Integer.MIN_VALUE;
		int maxRight = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;

		int sumMidLeft = 0;
		int sumMidRight = 0;
		int maxMidLeft = Integer.MIN_VALUE;
		int maxMidRight = Integer.MIN_VALUE;

		int mid = (begin + end) / 2;

		// 递归边界
		if (begin == end) {
			if (nums[begin] > 0) {
				return nums[begin];
			}
			return 0;
		}

		maxLeft = aux(nums, begin, mid);
		maxRight = aux(nums, mid + 1, end);

		// 计算左边部分包含中间时的最大值
		for (int i = mid; i >= begin; i--) {
			sumMidLeft += nums[i];
			maxMidLeft = maxMidLeft > sumMidLeft ? maxMidLeft : sumMidLeft;
		}

		// 计算右边部分包含中间时的最大值
		for (int i = mid + 1; i < end; i++) {
			sumMidRight += nums[i];
			maxMidRight = maxMidRight > sumMidRight ? maxMidRight : sumMidRight;
		}

		max = maxMidLeft + maxMidRight;

		int result = max > maxLeft ? max : maxLeft;
		result = result > maxRight ? result : maxRight;
		return result;
	}

	/**
	 * 线性时间算法，该算法在每次元素累加和小于0时，从下一个元素重新开始累加。
	 */
	// public int maxSubArray(int[] nums) {
	// // write your code
	// int sum = Integer.MIN_VALUE;
	// int maxVal = Integer.MIN_VALUE;
	// for (int i = 0; i < nums.length; i++) {
	// // 若sum<0，说明在上一段子数组中连加之和小于0，则上一段子数组最大值已经被记录
	// if (sum < 0) {
	// sum = nums[i];
	// } else {
	// sum += nums[i];
	// }
	// maxVal = maxVal > sum ? maxVal : sum;
	// }
	// return maxVal;
	// }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = { 2, 4, -7, 5, 2, -1, 2, -4, 3 };
		System.out.println(s.maxSubArray(nums));
	}
}