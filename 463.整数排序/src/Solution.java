public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        // Write your code here
    	//��������ÿ�ΰ�����ֵð�ݵ����һλ
        for(int i=A.length;i>0;i--){
        	for(int j=0;j<i-1;j++){
        		if(A[j]>A[j+1]){
        			int temp=A[j];
        			A[j]=A[j+1];
        			A[j+1]=temp;
        		}
        	}
        }
    }
}