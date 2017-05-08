public class Solution {
	/**
	 * @param A
	 *            an array of Integer
	 * @return an integer
	 */
	public int longestIncreasingContinuousSubsequence(int[] A) {
		// Write your code here
		if(A.length==0){
			return 0;
		}
		int maxCount = 1;
		int increasingCount = 1;
		int deincreasingCount = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i-1] ) {
				increasingCount++;
				maxCount = maxCount > deincreasingCount ? maxCount
						: deincreasingCount;
				deincreasingCount = 1;
			} else if (A[i] < A[i-1] ) {
				deincreasingCount++;
				maxCount = maxCount > increasingCount ? maxCount
						: increasingCount;
				increasingCount = 1;
			} else {
				increasingCount++;
				deincreasingCount++;
			}
		}
		int result=maxCount>increasingCount?maxCount:increasingCount;
		result=result>deincreasingCount?result:deincreasingCount;
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = { 5, 4, 2, 1, 3 };
		s.longestIncreasingContinuousSubsequence(nums);
	}
}