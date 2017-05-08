/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
	/**
	 * ˼·�����õݹ��ȡ������������ȣ�������ȵ�������������ȵ����ֵ��1
	 * ���η���1.����ֽ⣨1������������ȣ�2�������������
	 * 2.������� ���õݹ����
	 * 3.����ϲ� ����������Ƚϴ��߼�1��Ϊ�������
	 */
	
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
    	if(root==null){
    		return 0;
    	}
    	
    	int leftDepth=0;
    	int rightDepth=0;
    	if(root.left!=null){
    		leftDepth=maxDepth(root.left);
    	}
    	if(root.right!=null){
    		rightDepth=maxDepth(root.right);
    	}
    	if(rightDepth>leftDepth){
    		return rightDepth+1;
    	}else{
    		return leftDepth+1;
    	}
    }
}