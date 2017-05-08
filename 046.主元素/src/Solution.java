import java.util.ArrayList;

public class Solution {
	/**
	 * @param nums
	 *            : a list of integers
	 * @return: find a majority number
	 */
	public int majorityNumber(ArrayList<Integer> nums) {
		// write your code
		// ��Ԫ��
		int majority = Integer.MAX_VALUE;
		// ��Ԫ�صĴ���
		int numTime = 0;
		for (int i = 0; i < nums.size(); i++) {
			// ������Ԫ������Ԫ��һ��,Ԫ�ظ�����һ
			if (majority == nums.get(i)) {
				numTime++;
			}
			// ������Ԫ������Ԫ�ز�һ�£��жϴ�ʱ��Ԫ�صĴ���
			else if (numTime > 0) {// ��Ԫ�ش�������1����Ԫ�ش�����1
				numTime--;
			} else if (numTime == 0) {// ��Ԫ�ش�������0��������Ԫ��
				majority = nums.get(i);
				numTime++;
			}

		}

		return majority;
	}
}