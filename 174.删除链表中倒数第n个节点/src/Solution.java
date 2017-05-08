/**
 * Definition for ListNode. public class ListNode { int val; ListNode next;
 * ListNode(int val) { this.val = val; this.next = null; } }
 */
public class Solution {
	/**
	 * @param head
	 *            : The first node of linked list.
	 * @param n
	 *            : An integer.
	 * @return: The head of linked list.
	 */
	ListNode removeNthFromEnd(ListNode head, int n) {
		// write your code here
		
		//����ͷ���
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		//��������ָ�룬slow��fast 
		//fast����ǰ��n����slow��fastһ���ߣ�ֱ��fast�����һ����� 
		ListNode fast=dummy;
		ListNode slow=dummy;
		for(int i=0;i<n+1;i++){
			fast=fast.next;
		}
		while(fast!=null){
			slow=slow.next;
			fast=fast.next;
		}
		slow.next=slow.next.next;
		
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
