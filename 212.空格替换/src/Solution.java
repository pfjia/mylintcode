public class Solution {
	/**
	 * @param string
	 *            : An array of Char
	 * @param length
	 *            : The true length of the string
	 * @return: The true length of new string
	 */
	public int replaceBlank(char[] string, int length) {
		// Write your code here
		int i = 0;
		while (i < length) {
			// ���ֿո�
			if (string[i] == ' ') {
				length += 2;
				// �ѿո����ַ�����ƶ�����λ��
				for (int j = length - 1; j > i + 2; j--) {
					string[j] = string[j - 2];
				}
				string[i] = '%';
				string[i + 1] = '2';
				string[i + 2] = '0';
				i += 3;
			} else {
				i++;
			}
		}
		return length;
	}
}