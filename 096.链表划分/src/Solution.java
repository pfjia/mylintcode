/**
 * Definition for ListNode. public class ListNode { int val; ListNode next;
 * ListNode(int val) { this.val = val; this.next = null; } }
 */
public class Solution {
	/**
	 * ����������һ�����������ֵx����������ʹ������С��x�Ľڵ����ڴ��ڵ���x�Ľڵ�֮ǰ�� ��Ӧ�ñ���������������ڵ�ԭ�е����˳��
	 * ˼·�������б�xС�Ľڵ���뵽ǰ�棬��x��Ļ���ڵĲ���
	 */
	/**
	 * @param head
	 *            : The first node of linked list.
	 * @param x
	 *            : an integer
	 * @return: a ListNode
	 */
	public ListNode partition(ListNode head, int x) {
		// write your code here

		// �ж�head�Ƿ�Ϊ��
		if (head == null) {
			return head;
		}

		// ͷ���
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// һ����־λ���ж��Ƿ�ִ���˲������
		boolean insert;

		ListNode i = dummy;
		ListNode j = dummy;
		while (i.next != null) {
			// ��־λ��λ
			insert = false;

			// �жϵ�ǰ�ڵ��ֵ�Ƿ���ڵ���x�����򲻱䣬���������
			if (i.next.val < x) {
				if (i == j) {
					// ���i==j��Ҳ��Ҫ���룬���ǲ����κβ����������i����j��λ����
					i = i.next;
					j = j.next;
					insert = true;
				} else {

					// ����
					ListNode temp = i.next;
					i.next = i.next.next;
					temp.next = j.next;
					j.next = temp;
					// j��λ
					j = j.next;
					// ���Ĳ����־
					insert = true;
				}
			}

			// ���û�в��������i�ƺ�һλ
			if (!insert) {
				i = i.next;
			}
		}
		return dummy.next;
	}

	public ListNode intToListNode(int x) {
		int yushu;
		ListNode head = new ListNode(0);
		ListNode now = head;

		while (x > 0) {
			yushu = x % 10;
			now.next = new ListNode(yushu);
			now = now.next;
			x = x / 10;
		}
		return head.next;
	}
}
