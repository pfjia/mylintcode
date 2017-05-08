import java.util.Arrays;

/**
 * Created by pfjia on 2017/5/8 0008.
 */
public class Solution {
	/**
	 * @param nums:
	 *            A list of integer which is 0, 1 or 2
	 * @return: nothing
	 */
	//扫描两次数组，第一次计数，第二次赋值
//	public void sortColors(int[] nums) {
//		// write your code here
//		int zeroCount = 0;
//		int oneCount = 0;
//		int twoCount = 0;
//		for (int n : nums) {
//			switch (n) {
//				case 0:
//					zeroCount++;
//					break;
//				case 1:
//					oneCount++;
//					break;
//				case 2:
//					twoCount++;
//					break;
//			}
//		}
//		for(int i=0;i<zeroCount;i++){
//			nums[i]=0;
//		}
//		for(int i=zeroCount;i<zeroCount+oneCount;i++){
//			nums[i]=1;
//		}
//		for(int i=zeroCount+oneCount;i<zeroCount+oneCount+twoCount;i++){
//			nums[i]=2;
//		}
//	}

	public void sortColors(int[] nums) {
		// write your code here
		int l=0;//指向第一个非0
		int r=nums.length-1;//指向最后一个非2
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0){
				l++;
			}else{

			}

		}
	}
}
