/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here
    	if (head == null) {
			return null;
		}
		ListNode now = head;
		ListNode bianli = head;
		// ѭ���������鿴��ǰԪ���Ƿ����ǰ���ֵ�Ԫ��һ��
		while (now != null) {
			bianli=head;
			if(now.next==now){
				return now;
			}
			while (bianli != now) {
				if (now.next == bianli) {
					return bianli;
				}
				bianli = bianli.next;
			}
			now = now.next;
		}
		return null;
    }
}
