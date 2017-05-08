/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Solution {
	/**
	 * @param head
	 *            a ListNode
	 * @param val
	 *            an integer
	 * @return a ListNode
	 */
	public ListNode removeElements(ListNode head, int val) {
		// Write your code here
		// ��ͷ���ɾ��ָ��Ԫ��
		// ȷ��ͷ����Ԫ�ز���val����ʱhead������null
		while (head != null && head.val == val) {
			head = head.next;
		}
		// һ��now��һ��before��֤����ɾ��
		ListNode now = null;
		ListNode before = head;
		while (before != null) {
			now = before.next;

			// �ж�now�ǲ��ǽ�Ҫɾ����Ԫ��
			// now���գ��ҿ�ɾ��
			if (now != null && now.val == val) {
				before.next = now.next;
			} else if (now == null) {// nowΪ��
				before = now;
			} else {// now�����Ҳ�ɾ��
				before = now;
			}
		}
		return head;
	}
}