import java.util.ArrayList;
import java.util.List;

/**
 * Created by pfjia on 2017/5/15.
 */
public class Solution {
	/**
	 * @param nums:
	 *            The rotated sorted array
	 * @return: void
	 */
	public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
		if (null == nums || nums.size() == 0)
			return;
		int min = SearchMin(nums);
		int len = nums.size();
		int peek = (min + len - 1) % len;
		if (peek == len - 1)
			return;
		rotateArray(nums,0,peek+1);
		rotateArray(nums,peek+1,nums.size());
		rotateArray(nums,0,nums.size());
	}

	/**
	 * 逆序[start,end)中的元素
	 * 
	 * @param nums
	 * @param start
	 * @param end
	 */
	public void rotateArray(List<Integer> nums, int start, int end) {

		for (int i = 0; i <=(end-start- 1) / 2; i++) {
			int temp = nums.get(start + i);
			nums.set(start + i, nums.get(end - i - 1));
			nums.set(end - i - 1, temp);
		}

	}

	/**
	 * 找到nums中最小值的index
	 * 
	 * @param nums
	 * @return
	 */
	public int SearchMin(ArrayList<Integer> nums) {
		int minNum = nums.get(0);
		int min = 0;
		for (int i = 1; i < nums.size(); i++) {
			if (minNum > nums.get(i)) {
				min = i;
				minNum = nums.get(i);
			}
		}
		return min;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arrNums = { 4, 5, 6, 7, 8, 10, 1, 2, 3 };
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i : arrNums) {
			nums.add(i);
		}

		s.recoverRotatedSortedArray(nums);

		System.out.println(nums);

	}
}
