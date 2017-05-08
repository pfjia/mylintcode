import java.util.Arrays;

/**
 * Created by pfjia on 2017/5/7.
 */
public class Solution {
	/**
	 * @param A:
	 *            sorted integer array A which has m elements, but size of A is
	 *            m+n
	 * @param B:
	 *            sorted integer array B which has n elements
	 * @return: void
	 */
	// 插入排序，把B中元素插入到A中，但是忽略了B是有序的这个条件
	// public void mergeSortedArray(int[] A, int m, int[] B, int n) {
	// // write your code here
	// for(int i=0;i<n;i++){
	// int temp=B[i];
	// int j=m;
	// for(;j>0;j--){
	// if(temp<A[j-1]){
	// A[j]=A[j-1];
	// }else {
	// break;
	// }
	// }
	// A[j]=temp;
	// m++;
	// }
	// }

	/**
	 * 使用A和B的最大值进行比较，每次比较确定一个最大值，最多m+n次比较
	 * 
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 */
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		// write your code here
		int i = m - 1;
		int j = n - 1;
		int index = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] > B[j]) {
				A[index] = A[i];
				i--;
				index--;
			} else {
				A[index] = B[j];
				j--;
				index--;
			}
		}
		//j>=0说明比较完毕后B中还有剩余，把B中剩余元素都复制到A中
        //如果i>=0，说明比较完毕后A中还有剩余，但A中剩余元素在A中已经有序，不需要复制
		while (j >= 0) {
			A[index] = A[j];
			j--;
			index--;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 6, 0, 0 };
		int[] b = { 2, 5 };
		Solution s = new Solution();
		s.mergeSortedArray(a, 4, b, 2);
		System.out.println(Arrays.toString(a));
	}
}