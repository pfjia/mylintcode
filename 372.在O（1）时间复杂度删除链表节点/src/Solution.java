/**
 * Definition for ListNode. public class ListNode { int val; ListNode next;
 * ListNode(int val) { this.val = val; this.next = null; } }
 */
public class Solution {
	/**
	 * @param node
	 *            : the node in the list should be deleted
	 * @return: nothing
	 */
	public void deleteNode(ListNode node) {
		// write your code here
		if(node==null){
			return;
		}else if(node.next==null){
			node=null;
			return;
		}
		// ɾ��next������node, ��Ϊû��prev�ڵ����Ϣ���Ը���next��nodeȻ��ɾ��next���൱��ɾ����node
		ListNode next=node.next;
		node.val=next.val;
		node.next=node.next.next;
	}
}