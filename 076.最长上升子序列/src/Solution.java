
public class Solution {
	/**
	 * @param nums
	 *            : The integer array
	 * @return: The length of LIS (longest increasing subsequence)
	 */
	public int longestIncreasingSubsequence(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}

		// ��ʼ��memo
		// memo[i]��ŵ����Ե�i��Ԫ��Ϊ�������յ�ʱ�����г���
		// ���Ҫ��Ӱ���0~i����Ԫ�ص�������У�Ϊmemo[0]~memo[i]�����ֵ
		int[] memo = new int[nums.length];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = Integer.MIN_VALUE;
		}
		memoSubLIS(nums, nums.length - 1, memo);
		return maxArrays(memo, memo.length - 1);
	}

	/**
	 * 
	 * @param nums
	 * @param index
	 * @param memo
	 * @return ������nums�д�0~indexԪ���е�LIS,���ص���memo�����ֵ��memo��������ֵ����LIS
	 */
	public int memoSubLIS(int[] nums, int index, int[] memo) {
		int result = 0;

		// ���ұ���
		if (memo[index] != Integer.MIN_VALUE) {
			return memo[index];
		}

		// �߽�
		if (index == 0) {
			memo[index] = 1;
			return 1;
		}
		/**
		 * index��LIS����0~index��LIS����index��LIS������ֵ
		 */
		else {
			for (int i = 0; i < index; i++) {

				int tempLis = 0;
				// �Ե�index��Ԫ��Ϊ�յ�����������к�
				int memoI = memoSubLIS(nums, i, memo);
				// ��ǰԪ�ش���nums[i]
				if (nums[index] > nums[i]) {
					tempLis = memoI + 1;
				}
				// ��ǰԪ�ز�����nums[i]
				else {
					tempLis = 1;
				}
				result = max(result, tempLis);
			}
		}

		// ���±���
		memo[index] = result;
		return result;
	}

	/**
	 * 
	 * @param nums
	 * @param index
	 * @return ������nums�д�0~indexԪ��������Ԫ��
	 */
	public int maxArrays(int[] nums, int index) {
		if (index >= nums.length) {
			return -1;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= index; i++) {
			max = max > nums[i] ? max : nums[i];
		}
		return max;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return �������е����ֵ
	 */
	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = { 88, 4, 24, 82, 86, 1, 56 };
		// int[] nums = { 88, 4, 24, 82, 86, 1, 56, 74, 71, 9, 8, 18, 26, 53,
		// 77,
		// 87, 60, 27, 69, 17, 76, 23, 67, 14, 98, 13, 10, 83, 20, 43, 39,
		// 29, 92, 31, 0, 30, 90, 70, 37, 59 };
		int[] memo = new int[nums.length];
		// for (int i = 0; i < memo.length; i++) {
		// memo[i] = Integer.MIN_VALUE;
		// }
		// for (int i = 0; i < nums.length; i++) {
		// int result = s.memoSubLIS(nums, i, memo);
		// System.out.println("��" + i + "�Σ������:" + result);
		// }
		int i = s.longestIncreasingSubsequence(nums);
		System.out.println(i);
	}
}
