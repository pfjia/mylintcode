/**
 * Definition for ListNode. public class ListNode { int val; ListNode next;
 * ListNode(int val) { this.val = val; this.next = null; } }
 */
public class Solution {

	/**
	 * ˼·1��ѭ��n/2�Σ�ÿ���ҵ����һ���ڵ㣬��������뵽ǰ�棬headָ��Ӧ�ò���λ�õ�ǰһ���ڵ㣬����beforeTail�ҵ�β�������ڶ���Ԫ��
	 * �������һ��Ԫ�ز���ǰ����а�beforeTail��next��null
	 * ����������˼·������ѭ����ʱ�临�Ӷ���o(n2)�����ҵ�head��beforeTailͬʱָ��һ��Ԫ��ʱ
	 * �����������ʧ�ܣ���Ҫ�ɹ�����һ���жϣ�����һ��tailӦ�þ�û�����ˣ�
	 */
	/**
	 * ˼·2�������Ƚ���������һ��Ϊ����Ȼ�󽫺����������������β���ǰ��νڵ��С�
	 * ����֪�����ÿ���ָ���˼��������ܹ��ҵ������е��м�ڵ㣻����������Բ���ǰ�巨��O(n)���ɽ�������Ը���Ŀ������ʱ�临�Ӷ�ΪO(n)��
	 */
	/**
	 * @param head
	 *            : The head of linked list.
	 * @return: void
	 */
	public void reorderList(ListNode head) {
		// write your code here
		// �ж��Ƿ�Ϊ�ջ���ֻ��һ���ڵ�
		if (head == null || head.next == null) {
			return;
		}
		// �ҵ������м�ڵ�
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}// slowָ���м�ڵ�

		// ���νڵ�����
		ListNode nextMid = slow.next;
		if (nextMid == null) {
			return;
		}
		while (nextMid.next != null) {
			ListNode needHeadInsert = nextMid.next;
			nextMid.next = needHeadInsert.next;

			needHeadInsert.next = slow.next;
			slow.next = needHeadInsert;

		}

		// �������Ľڵ���뵽ǰ��
		ListNode now = head;
		while (slow.next != null) {
			ListNode needInsert = slow.next;
			slow.next = needInsert.next;
			needInsert.next = now.next;
			now.next = needInsert;
			// ����now
			now = needInsert.next;
		}

	}
}