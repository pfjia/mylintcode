/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	/**
	 * @param l1
	 *            : the first list
	 * @param l2
	 *            : the second list
	 * @return: the sum list of l1 and l2
	 */
	public ListNode addLists(ListNode l1, ListNode l2) {
		// write your code here

		// ͷ��㣬������
		ListNode head = new ListNode(0);
		ListNode now = head;
		// ���������ͣ��ٽ��任Ϊ����
		// ����ķ������У���Ϊ��
		// 9->9->9->9->9->9->9->9->9->9->9->9->9->9->9
		// ->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->
		// 9->9->9->9->9->9->9->9->9->9->9->9->null,
		// 9->9->9->9->9->9->9->9->9->9->9->9->9->9->9
		// ->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->
		// 9->9->9->9->9->9->9->9->9->9->9->9->null����������,�ҷ���

		int jinwei = 0;
		int tempResult = 0;

		// ��������ֻҪ��һ����Ϊ�վͼ���ѭ��
		while (l1 != null || l2 != null) {
			// l1���������
			if (l1 != null) {
				if (l2 != null) {
					// l1,l2����Ϊ��
					tempResult = jinwei + l1.val + l2.val;
					if (tempResult > 9) {
						jinwei = tempResult / 10;
						now.next = new ListNode(tempResult % 10);
					} else {
						jinwei=0;
						now.next = new ListNode(tempResult);
					}
					l2 = l2.next;
				} else {
					tempResult = jinwei + l1.val;
					if (tempResult > 9) {
						jinwei = tempResult / 10;
						now.next = new ListNode(tempResult % 10);
					} else {
						jinwei=0;
						now.next = new ListNode(tempResult);
					}
				}
				l1 = l1.next;
			} else {
				// l1Ϊ�գ���l2�ز�Ϊ��
				tempResult = jinwei + l2.val;
				if (tempResult > 9) {
					jinwei = tempResult / 10;
					now.next = new ListNode(tempResult % 10);
				} else {
					jinwei=0;
					now.next = new ListNode(tempResult);
				}
				l2 = l2.next;
			}
			now = now.next;
		}
		if(jinwei!=0){
			now.next=new ListNode(jinwei);
		}
		return head.next;
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
