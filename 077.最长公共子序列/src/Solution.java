public class Solution {
	/**
	 * @param A
	 *            , B: Two strings.
	 * @return: The length of longest common subsequence of A and B.
	 */

	// ���¶���
	public int longestCommonSubsequence(String A, String B) {
		// write your code here
		if (A == null || B == null || A.length() == 0 || B.length() == 0) {
			return 0;
		}
		int aLen = A.length();
		int bLen = B.length();
		int[][] memo = new int[aLen + 1][bLen + 1];
		// ��memo���г�ʼ��
		for (int i = 0; i < memo.length; i++) {
			memo[i][0] = 0;
		}
		for (int i = 0; i < memo[0].length; i++) {
			memo[0][i] = 0;
		}
		for (int i = 1; i < memo.length; i++) {
			for (int j = 1; j < memo[0].length; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					memo[i][j] = memo[i - 1][j - 1] + 1;
				} else {
					memo[i][j] = memo[i][j - 1] > memo[i - 1][j] ? memo[i][j - 1]
							: memo[i - 1][j];
				}
			}
		}
		int maxLength = 0;
		// ����memo���ҵ���󳤶�
		for (int i = 1; i < memo.length; i++) {
			for (int j = 1; j < memo[0].length; j++) {
				maxLength = maxLength > memo[i][j] ? maxLength : memo[i][j];
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String a = "bedaacbade";
		String b = "dccaeedbeb";
		System.out.println(s.longestCommonSubsequence(a, b));
	}
}
