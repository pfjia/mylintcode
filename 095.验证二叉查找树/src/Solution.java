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
	 * ���η�����������ֽ⡡�����������ǲ��ǲ�����
	 * ����������⡡�ݹ�
	 * ��������ϲ�������������������һ�����ǲ����������ǲ��������������ǲ��������ж����ҽڵ��ֵ
	 */
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
    	if(root==null){
    		return true;
    	}
    	
    	if(root.left!=null){
    		if(root.left.val>root.val||!isValidBST(root.left)){
    			return false;
    		}
    	}
    	if(root.right!=null){
    		if(root.right.val<root.val||!isValidBST(root.right)){
    			return false;
    		}
    	}
    	
    	return true;
    }
}