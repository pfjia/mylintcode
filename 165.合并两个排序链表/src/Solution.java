/**
 * Definition for ListNode. public class ListNode { int val; ListNode next;
 * ListNode(int val) { this.val = val; this.next = null; } }
 */
public class Solution {
	/**
	 * @param ListNode
	 *            l1 is the head of the linked list
	 * @param ListNode
	 *            l2 is the head of the linked list
	 * @return: ListNode head of linked list
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// write your code here
		ListNode dummy1 = new ListNode(0);
		dummy1.next = l1;
		ListNode dummy2 = new ListNode(0);
		dummy2.next = l2;

		ListNode i = dummy1;
		ListNode j = dummy2;
		ListNode temp = null;

		// ��l2����l1��
		while (i.next != null && j.next != null) {
			if (j.next.val > i.next.val) {
				// l2��Ԫ�ش���l1
				// �ҵ����ʵ�λ�ã���l2��Ԫ�ز����ȥ
				while (i.next!=null&&i.next.val < j.next.val) {
					i = i.next;
				}
				//��l2��Ԫ�ض�����l1��ʱ
				if(i.next==null){
					i.next=j.next;
					return dummy1.next;
				}

				temp = j.next;
				j.next = j.next.next;
				temp.next = i.next;
				i.next = temp;

				// ����i��j
				i=i.next;
			} else {
				// l1��Ԫ�ش���l2
				// ��l2���뵽ǰ��
				temp = j.next;
				j.next = j.next.next;
				temp.next = i.next;
				i.next = temp;

				// ����i��j
				i = i.next;
			}
		}
//l1��Ϊ�գ��򷵻�l2
		if(dummy1.next==null){
			return dummy2.next;
		}
		return dummy1.next;
	}
	
	//ͷ�巨������
	public ListNode headInsert(int[] s){
		ListNode dummy=new ListNode(0);
		ListNode now=dummy;
		for(int i=0;i<s.length;i++){
			now.next=new ListNode(s[i]);
			now=now.next;
		}
		return dummy.next;
		
	}
}