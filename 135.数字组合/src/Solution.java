import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	/**
	 * @param candidates
	 *            : A list of integers
	 * @param target
	 *            :An integer
	 * @return: A list of lists of integers
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		// write your code here
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		helper(candidates, 0, target, new ArrayList<Integer>(), res);
		return res;
	}

	private void helper(int[] candidates, int start, int target,
			List<Integer> item, List<List<Integer>> res) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			res.add(new ArrayList<>(item));
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			if (i > 0 && candidates[i] == candidates[i - 1]) {
				continue;
			}
			item.add(candidates[i]);
			helper(candidates, i, target - candidates[i], item, res);
			item.remove(item.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		System.out.println(s.combinationSum(candidates, target));
	}
}