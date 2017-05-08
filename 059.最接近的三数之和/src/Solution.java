import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pfjia on 2017/5/8 0008.
 */
public class Solution {
	/**
	 * @param numbers:
	 *            Give an array numbers of n integer
	 * @param target
	 *            : An integer
	 * @return : return the sum of the three integers, the sum closest target.
	 */
	public int threeSumClosest(int[] numbers, int target) {
		// write your code here
		Arrays.sort(numbers);
		int closest = numbers[0] + numbers[1] + numbers[2];
		int diff = Math.abs(closest - target);
		for (int i = 0; i < numbers.length; i++) {
			int l = i + 1;
			int h = numbers.length - 1;
			while (l < h) {
				int sum = numbers[i] + numbers[l] + numbers[h];
				int newDiff = Math.abs(sum - target);
				//判断由sum==0，改为判断newDiff和diff的大小
				if (newDiff < diff) {
					// 更新
					diff = newDiff;
					closest = sum;
				}
				if (sum < target) {
					l++;
				} else {
					h--;
				}
			}
		}
		return closest;
	}

}