import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

//�鲢����������
public class DataGenerator {
	private static char[] chars = ("abcdefghijklmnopqrstuvwxyz"
			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

	// ��ǰ�����ڵ����������ϲ���һ�������
	private void merge(int nums[], int low, int mid, int high) {
		// ��һ������� low-mid
		// �ڶ��������mid+1-high
		int[] tempNums = new int[nums.length];
		// ��ԭ����Ԫ�ظ��Ƶ���ʱ������
		for (int k = low; k <= high; k++) {
			tempNums[k] = nums[k];
		}
		int i;
		int j;
		int k;
		for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
			// ��Сֵ���Ƶ�ԭ������
			if (tempNums[i] <= tempNums[j]) {
				nums[k] = tempNums[i++];
			} else {
				nums[k] = tempNums[j++];
			}

		}
		// ����һ����δ����꣬����
		while (i <= mid) {
			nums[k++] = tempNums[i++];
		}
		// ���ڶ�����Ϊ����꣬����
		while (j <= high) {
			nums[k++] = tempNums[j++];
		}

	}

	private void mergeSort(int nums[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(nums, low, mid);
			mergeSort(nums, mid + 1, high);
			merge(nums, low, mid, high);
		}
	}

	/**
	 * �����������Ԫ��
	 * 
	 * @param length
	 *            ����Ԫ�ظ���
	 * @param maxNum
	 *            Ԫ�����ֵ
	 * @param minNum
	 *            Ԫ����Сֵ
	 * @return ����Ԫ������
	 */
	private int[] generateUnorderedDatas(int length, int maxNum, int minNum) {
		int[] result = new int[length];
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			result[i] = random.nextInt(maxNum - minNum) + minNum;
		}
		return result;
	}

	/**
	 * ���ļ���׷������Ԫ�أ�û��/n
	 * 
	 * @param fileName
	 * @param length
	 * @param maxNum
	 * @param minNum
	 * @throws IOException
	 */
	public String getUnorderedIntegers(int length, int maxNum, int minNum) {
		int[] result = generateUnorderedDatas(length, maxNum, minNum);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length - 1; i++) {
			sb.append(result[i]);
		}
		sb.append(result[length - 1]);
		return sb.toString();
	}

	/**
	 * ���ļ���׷������Ԫ��,û��/n
	 * 
	 * @param fileName
	 * @param length
	 * @param maxNum
	 * @param minNum
	 * @throws IOException
	 */
	public String getOrderedIntegers(int length, int maxNum, int minNum) {
		int[] result = generateUnorderedDatas(length, maxNum, minNum);
		mergeSort(result, 0, length - 1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length - 1; i++) {
			sb.append(result[i]);
		}
		sb.append(result[length - 1]);
		return sb.toString();
	}

	/**
	 * 
	 * @param length
	 *            ����String�ĳ���
	 * @return �����ַ���
	 */
	public String getUnorderedString(int length) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(chars[rand.nextInt(chars.length)]);
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param length
	 *            ����String�ĳ���
	 * @return �����ַ���
	 */
	public String getOrderedString(int length) {
		Random rand = new Random();
		char[] temp = new char[length];
		for (int i = 0; i < length; i++) {
			temp[i] = chars[rand.nextInt(chars.length)];
		}
		Arrays.sort(temp);
		return String.valueOf(temp);
	}

	public String getUnorderedString(int length, char[] chars) {
		Random rand = new Random();
		char[] temp = new char[length];
		temp[0] = chars[rand.nextInt(chars.length - 1) + 1];
		for (int i = 1; i < length; i++) {
			temp[i] = chars[rand.nextInt(chars.length)];
		}
		return String.valueOf(temp);
	}

}
