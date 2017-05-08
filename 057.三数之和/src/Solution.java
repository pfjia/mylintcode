import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pfjia on 2017/5/8.
 */
public class Solution {
	/**
	 * @param numbers
	 *            : Give an array numbers of n integer
	 * @return : Find all unique triplets in the array which gives the sum of
	 *         zero.
	 */

	// 排序后暴力穷举
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		// write your code here
		// 排序
		Arrays.sort(numbers);
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			// 使用下面注释掉的方法去除重复值不可行，因为把还没有计算过的值去除，但是去除的值可能会在三个数之中
			// 当前值和后面值相同，去除（错误）
			// if(i+1<numbers.length&&numbers[i]==numbers[i+1]){
			// continue;
			// }
			// 当前值和前面值相同，去除
			if (i > 0 && numbers[i - 1] == numbers[i]) {
				continue;
			}
			ArrayList<ArrayList<Integer>> twoSums = twoSum(numbers, i + 1,
					-numbers[i]);
			if (twoSums.size() > 0) {
				for (ArrayList<Integer> integers : twoSums) {
					integers.add(0, numbers[i]);
					// 经过twoSum和上面的去重后，results中不可能包含重复值
					results.add(integers);
				}
			}
		}
		return results;
	}

	/**
	 * 计算在numbers中[index,numbers.length-1)中两个元素和为sum的数
	 * 
	 * @param numbers
	 * @param index
	 * @param sum
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> twoSum(int[] numbers, int index,
			int sum) {
		// 元素是有序的，不用两两相比较
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		int l = index;
		int h = numbers.length - 1;
		while (l < h) {
			if (numbers[l] + numbers[h] == sum) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(numbers[l]);
				temp.add(numbers[h]);
				if (!results.contains(temp)) {
					results.add(temp);
				}

				// 去除重复值
				while (l < h && numbers[l] == numbers[l + 1]) {
					l++;
				}
				while (l < h && numbers[h] == numbers[h - 1]) {
					h--;
				}

				l++;
				h--;
			} else if (numbers[l] + numbers[h] < sum) {
				l++;
			} else {
				h--;
			}
		}
		return results;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = { -2, -3, 5, -1, -4, 5, -11, 7, 1, 2, 3, 4, -7, -1, -2, -3,
				-4, -5 };
		ArrayList<ArrayList<Integer>> results = s.threeSum(nums);
		System.out.println(results);
	}
}