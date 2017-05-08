class Solution {
	/**
	 * ˼·: 1.���n Ϊ��������ת��Ϊ (a^(n/2) * a^(n/2) * a ) %b = ((a^(n/2)%b *
	 * a^(n/2)%b)%b * a%b) %b 2. ���n Ϊż������ת��Ϊ (a^(n/2) * a^(n/2) ) %b =
	 * (a^(n/2)%b * a^(n/2)%b)%b /
	 * 
	 */
	/**
	 * 
	 * @param a
	 *            , b, n: 32bit integers
	 * @return: An integer
	 */
	public int fastPower(int a, int b, int n) {
		// write your code here
		// �ݹ��˳�����
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return a % b;
		}
		int temp = fastPower(a, b, n / 2);
		if ((n & 1) == 1) {// ���n������
			return ((temp * temp) % b * a % b) % b;
		}
		// ���n��ż��
		else {
			return (temp * temp) % b;
		}
	}
};