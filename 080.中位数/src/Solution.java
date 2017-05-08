public class Solution {
	/**
	 * @param nums:
	 *            A list of integers.
	 * @return: An integer denotes the middle number of the array.
	 */

	/**
	 * 解法1：排序后输出中间位置的元素
	 * 
	 * @param nums
	 * @return
	 */
	// public int median(int[] nums) {
	// // write your code here
	// sort(nums);
	// int mid = (nums.length - 1) / 2;
	// return nums[mid];
	// }

	/**
	 * 解法2：利用快排思想，每次找到一个元素在排序后的位置，该位置若是执行位置，输出；否则，更改快排范围，继续循环
	 * 
	 * @param nums
	 * @return
	 */
	public int median(int[] nums) {
		// write your code here
		int l = 0;
		int h = nums.length - 1;
		int k = 0;
		int mid = (nums.length - 1) / 2;
		while (k != mid) {
			k = partition(nums, l, h);
			if (k < mid) {
				l = k + 1;
			} else if (k > mid) {
				h = k - 1;
			}
		}
		return nums[mid];
	}

	/**
	 * 进行一次划分，把low位置上的元素放置在排序后的位置上 划分范围[low,high]
	 */
	public int partition(int[] nums, int low, int high) {
		int pviot = nums[low];
		int l = low;
		int h = high;
		while (l < h) {
			while (l < h && nums[h] >= pviot) {
				h--;
			}
			if (l < h) {
				swap(nums, l, h);
				l++;
			}

			while (l < h && nums[l] <= pviot) {
				l++;
			}
			if (l < h) {
				swap(nums, l, h);
				h--;
			}
		}
		return l;
	}

	/**
	 * 选择排序 时间复杂度 o（n2）
	 */
	public void sort(int[] nums) {
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			int minIndex = i;
			// 找到i+1到length-1中最小的元素下标
			for (int j = i + 1; j < length; j++) {
				minIndex = nums[minIndex] < nums[j] ? minIndex : j;
			}
			// 交换i与minIndex的元素值
			swap(nums, i, minIndex);
		}
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = { 4, 5, 1, 2, 3 };
		System.out.println(s.median(nums));
	}

}
