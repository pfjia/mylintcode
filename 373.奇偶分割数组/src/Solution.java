import java.util.Arrays;

/**
 * Created by pfjia on 2017/5/15.
 */
public class Solution {
	/**
     * 目标:奇前偶后
     * 方法:找到第一个偶数,找到其后第一个奇数,互换位置(类似于移动0的思路)
     *
	 * @param nums:
	 *            an array of integers
	 * @return: nothing
	 */
	public void partitionArray(int[] nums) {
		// write your code here;
        if(nums.length==0){
            return;
        }

        //找到第一个偶数的位置
        int left=0;
        while(left<nums.length&&isOdd(nums[left])){
            left++;
        }


        int right=left+1;
        //找到第一个偶数后奇数的位置
        while(right<nums.length&&isEven(nums[right])){
            right++;
        }

        while(right<nums.length){
            //循环第一次,执行交换操作
            if(isOdd(nums[right])){
                swap(nums,left,right);
                left++;
                right++;
            }
            //执行第一次循环后,right已经是偶数,寻找下一个奇数的位置
            else {
                right++;
            }
        }



	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

    /**
     * 判断i是否是奇数
     * @param i
     * @return
     */
	public boolean isOdd(int i){
        return  (i&1)==1;
    }

    /**
     * 判断i是否是偶数
     * @param i
     * @return
     */
    public boolean isEven(int i){
	    return !isOdd(i);
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int[]nums={2147483644,2147483645,2147483646,2147483647};
        s.partitionArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
