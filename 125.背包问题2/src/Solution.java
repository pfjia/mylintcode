public class Solution {
	/**
	 * @param m
	 *            : An integer m denotes the size of a backpack
	 * @param A
	 *            & V: Given n items with size A[i] and value V[i]
	 * @return: The maximum value
	 */
	public int backPackII(int m, int[] A, int V[]) {
		// write your code here
		/**
		 * ��ʼ���������� ���������ά����������Ĳ����й�,�����������Ǽ�ά ��ǰ������Ĳ��������� 1.����ʣ��ռ�
		 * 2.��ѡ����Ʒ����ʹ�ÿ�ѡ��Ʒ�����index����
		 */
		int memo[][] = new int[m + 1][A.length + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < A.length + 1; j++) {
				memo[i][j] = -1;
			}
		}
		return memoSubBackPackAux(m, A, V, A.length - 1, memo);
	}

	/**
	 * �������� ��������С��������ѡ��Ʒ��Ŀ���ı䣬�����������ǲ����� ��Ҫ������Ʒ�����ж�ÿ����Ʒ�Ĵ�С
	 * 
	 * @param m
	 *            ����ʣ��ռ�
	 * @param A
	 *            ��Ʒ����
	 * @param num
	 *            ��ѡ��Ʒ��������0~num����ѡ(��ʼnum�����鳤��-1)
	 * @param memo
	 *            ��������
	 * @return
	 */
	public int memoSubBackPackAux(int m, int[] A, int[] V, int num, int[][] memo) {
		int result = 0;
		// ����¼���Ѵ�����Ӧֵ
		if (memo[m][num] != -1) {
			return memo[m][num];
		}
		// �߽�����,��ѡ��Ʒֻ��һ��
		if (num == 0) {
			// ����ʣ��ռ����װ�����һ����Ʒ
			if (m >= A[num]) {
				result = V[num];
			}
			// ����ʣ��ռ�װ�������һ����Ʒ
			else {

				result = 0;
			}
		}
		// �ֽ�Ϊ������
		else if (m >= A[num]) {// ����ʣ��ռ��㹻װ�µ�ǰ��Ʒ
			// �������������ȡ���ֵ
			result = max(
					memoSubBackPackAux(m, A, V, num - 1, memo),
					(V[num] + memoSubBackPackAux(m - A[num], A, V, num - 1,
							memo)));
		} else {// ����ʣ��ռ��㹻װ�µ�ǰ��Ʒ
			// �����ǲ�װ�����
			result = memoSubBackPackAux(m, A, V, num - 1, memo);
		}
		// ���±���
		memo[m][num] = result;
		return result;
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}
}