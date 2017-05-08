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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
    	//�ж�head�Ƿ�Ϊ��
    	if(head==null){
    		return head;
    	}
    	
    	//ͷ���
    	ListNode dummy=new ListNode(0);
    	dummy.next=head;
    	//һ����־λ���ж��Ƿ�ִ���˲������
    	boolean insert;
    	
    	//n������Ҫѭ��n-1�Σ����Դ�����ĵڶ�������ʼѭ��
    	ListNode i=dummy.next;
    	ListNode j=null;
    	while(i.next!=null){
    		//��־λ��λ
    		insert=false;
    		//��j��λ
    		j=dummy;
    		while(j!=i){
    			//j��i���бȽ�
    			if(i.next.val<j.next.val){
    				//С����룬���򲻱�
    				ListNode temp=i.next;
    				i.next=i.next.next;
    				temp.next=j.next;
    				j.next=temp;
    				insert=true;
    				break;
    			}
    			//j�ƺ�һλ
    			j=j.next;
    		}
    		//���û�в��������i�ƺ�һλ
    		if(!insert){
        		i=i.next;
    		}
    	}
    	
    	return dummy.next;
    }
}