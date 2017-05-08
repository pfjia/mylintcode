/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class Solution {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
    	if(headA==null){
    		return null;
    	}
    	ListNode nowA=headA;
    	ListNode nowB=headB;
    	//����A�����ж���û��Ԫ����B������һ��
    	while(nowA!=null){
    		nowB=headB;
    		while(nowB!=null){
    			if(nowB==nowA){
    				return nowA;
    			}
    			nowB=nowB.next;
    		}
    		nowA=nowA.next;
    	}
    	return null;
    }  
}