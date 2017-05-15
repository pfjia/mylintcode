import java.util.Arrays;

/**
 * Created by pfjia on 2017/5/8.
 */
public class Solution {
	/**
	 * 把所有非0元素向前移动，补0的位置，最后剩余元素用0补齐
	 *
	 * @param nums
	 *            an integer array
	 * @return nothing, do this in-place
	 */
	// public void moveZeroes(int[] nums) {
	// // Write your code here
	// if (nums.length == 0) {
	// return;
	// }
	// int moveIndex = 0;
	// for (int i = 0; i < nums.length; i++) {
	// if (nums[i] != 0) {
	// if (moveIndex != i) {
	// //如果moveIndex和i不在同一个位置，则把元素向前移动，补0的位置
	// nums[moveIndex] = nums[i];
	// }
	// moveIndex++;
	// }
	// //没有else，当出现一个0时moveIndex和i再也无法相等
	// }
	// for(int i=moveIndex;i<nums.length;i++){
	// nums[i]=0;
	// }
	// }

	/**
	 * 找到第一个0位置， 找到第一个非0位置，交换
	 * 
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
		// Write your code here
		if (nums.length == 0) {
			return;
		}
		int left = 0;

		//找到第一个0位置
		while (left < nums.length) {
			if (nums[left] == 0) {
				break;
			}
			left++;
		}
		int right = left + 1;
		//找到left后第一个非0位置
		while (right < nums.length) {
			if (nums[right] != 0) {
				break;
			}
			right++;
		}

		//因为right是left后第一个非0位置，交换后left+1的位置一定是0
        //只要right还在数组范围内，就找到一个非0位置，进行交换
		while (right < nums.length) {
			if (nums[right] != 0) {
				swap(nums, left++, right++);
			} else {
				right++;
			}
		}

	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {0,1,0,5,0,4,3,2,1};
		s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}