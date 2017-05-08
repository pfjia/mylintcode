import java.util.ArrayList;

public class Solution {

	/**
	 * ˼·:
	 * 
	 * ά��������Ԫ�أ� ���������Ԫ������Ԫ��һ�£���Ӧ��Ԫ�ظ�����1�� �����һ�£��ж���Ԫ�ظ����Ƿ�Ϊ0�����������Ԫ�أ�
	 * ���ǣ���������Ԫ�صĸ�������1��
	 */
	/**
	 * @param nums
	 *            : A list of integers
	 * @return: The majority number that occurs more than 1/3
	 */
	public int majorityNumber(ArrayList<Integer> nums, int k) {
		// write your code
		// ʹ�����鱣����Ԫ�أ�������map���ܶ�Ƚ�Ҫ��ѭ����
		// ��ʼ������
		int[][] majority = new int[k][2];
		for (int j = 0; j < majority.length; j++) {
			majority[j][0] = Integer.MAX_VALUE;
			majority[j][1] = 0;
		}

		for (int i = 0; i < nums.size(); i++) {
			boolean flag = false;
			// �жϵ�ǰ����Ԫ�����Ƿ���ֵ�͵�ǰԪ����ȵ�
			for (int j = 0; j < majority.length; j++) {
				if (majority[j][0] == nums.get(i)) {
					flag = true;
					break;
				}
			}
			// ��������,����ȼ�һ����һ������
			if (flag == true) {
				for (int j = 0; j < majority.length; j++) {
					if (majority[j][0] == nums.get(i)) {
						majority[j][1]++;
					}
				}
			}
			// �������ȣ����ж�������Ԫ�ظ�����û��Ϊ0
			else {
				boolean isZero = false;
				for (int j = 0; j < majority.length; j++) {
					if (majority[j][1] == 0) {
						isZero = true;
						break;
					}
				}
				// �����Ϊ0���������Ԫ��
				// ��Ϊ��ͬʱΪ0�Ŀ��ܣ���������һ��0���break
				if (isZero) {
					for (int j = 0; j < majority.length; j++) {
						if (majority[j][1] == 0) {
							majority[j][0] = nums.get(i);
							majority[j][1] = 1;
							break;
						}
					}
				}
				// �����Ϊ0,������Ԫ�ظ�������1
				else {
					for (int j = 0; j < majority.length; j++) {
						majority[j][1]--;
					}
				}
			}
		}

		// ����ȫ������֮��������Ԫ����һ����һ����������Ԫ�أ����ǲ���ͨ��������Ԫ�ش����Ƚϣ��������±�������¼������Ԫ�ش���
		// ��Ԫ�ش�����Ϊ0
		for (int j = 0; j < majority.length; j++) {
			majority[j][1] = 0;
		}
		for (int i = 0; i < nums.size(); i++) {
			for (int j = 0; j < majority.length; j++) {
				if (nums.get(i) == majority[j][0]) {
					majority[j][1]++;
					break;
				}
			}
		}

		// ����ȫ������֮����Ԫ���нϴ�ľ�����������Ԫ��
		int maxCounter = 0;
		int mNum = 0;
		for (int j = 0; j < majority.length; j++) {
			if (maxCounter < majority[j][1]) {
				maxCounter = majority[j][1];
				mNum = majority[j][0];
			}
		}
		return mNum;
	}
}
