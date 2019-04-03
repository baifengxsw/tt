package cn.itcast10_list;

public class ReverseList {
	 public ListNode reverseList(ListNode head) {
	        if(head == null||head.next==null)
	        	return head;
	        ListNode cur =head;
	        ListNode pre = null;
	       
	        while(cur!=null) {
	        	ListNode nextNode = cur.next;
	        	cur.next = pre;
	        	pre = cur;
	        	cur = nextNode;
	        }
	        return pre;
	    }
}
