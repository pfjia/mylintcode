public class Solution {
	/**
	 * @param nums:
	 *            The integer array.
	 * @param target:
	 *            Target to find.
	 * @return: The first position of target. Position starts from 0.
	 */
    /**
     * 注意事项：1.元素有重复值，二分法查找到的第一个元素不一定是target第一次出现的下标
     * @param nums
     * @param target
     * @return
     */
	public int binarySearch(int[] nums, int target) {
		// write your code here
		int begin = 0;
		int end = nums.length - 1;
		while (begin < end) {
			int mid = (begin + end) / 2;
			if (nums[mid] < target) {
				begin = mid+1;
			}
			//有可能元素等于target，不能令end=mid-1
			else {
				end = mid;
			}
		}
		if (nums[begin] == target) {
			return begin;
		} else if(nums[end]==target){
			return end;
		}else {
		    return -1;
        }
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = { 3, 4, 5, 8, 8, 8, 8, 10, 13, 14 };
		int index = s.binarySearch(nums, 8);
		System.out.println(index);
	}
}