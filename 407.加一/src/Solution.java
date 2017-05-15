/**
 * Created by pfjia on 2017/5/15.
 */
public class Solution {
	/**
	 * @param digits
	 *            a number represented as an array of digits
	 * @return the result
	 */
	public int[] plusOne(int[] digits) {
		// Write your code here
		return plusOne(digits, digits.length - 1);
	}

	/**
	 * 辅助函数,在digits数组的index位置上加1
	 * 
	 * @param digits
	 * @param index
	 * @return
	 */
	public int[] plusOne(int[] digits, int index) {
		if (index >= digits.length) {
			throw new ArrayIndexOutOfBoundsException(
					"index: " + index + ", digits.length: " + digits.length);
		}
		// 在该位置上加1不进位
		if (digits[index] < 9) {
			digits[index] += 1;
			return digits;
		}
		// 加一进位
		else if (digits[index] == 9) {
		    //加一后当前位置0
            digits[index] = 0;

			// 最高位加一出现进位,扩充数组
			if (index == 0) {
			    int[]result=new int[digits.length+1];
			    System.arraycopy(digits,0,result,1,digits.length);
			    result[0]=1;
			    return result;
			}
			// 交给上一位处理
			else {
				return plusOne(digits, index - 1);
			}
		}
		return null;
	}
}
