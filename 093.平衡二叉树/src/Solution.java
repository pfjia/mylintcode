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
	 * ˼·��
	 * ���η���1.����ֽ� ��1���������ǲ���ƽ������2���������ǲ���ƽ����
	 * 2.������� �ݹ����
	 * 3.����ϲ� ��1������������һ������ƽ��������������ƽ����
	 * ��2��������������ƽ������������������������ж����ǲ���ƽ����
	 * 
	 */
	
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
    	if(root==null){
    		return true;
    	}
    	//����ֽ�
    	if(root.left!=null){
    		if(!isBalanced(root.left)){
    			return false;
    		}
    	}
    	if(root.right!=null){
    		if(!isBalanced(root.right)){
    			return false;
    		}
    	}
    	
    	//�ж������������֮���Ƿ���2
    	int leftDepth=0;
    	int rightDepth=0;
    	if(root.left!=null){
    		leftDepth=maxDepth(root.left);
    	}
    	if(root.right!=null){
    		rightDepth=maxDepth(root.right);
    	}
    	int cha=rightDepth-leftDepth;
    	if(cha>=2||cha<=-2){
    		return false;
    	}
    	return true;
    	
    	//
    	
    }
    
    
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