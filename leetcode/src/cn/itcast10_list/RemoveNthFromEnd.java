package cn.itcast10_list;
/**
 * ����һ������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ��㡣

ʾ����

����һ������: 1->2->3->4->5, �� n = 2.

��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
˵����

������ n ��֤����Ч�ġ�

���ף�

���ܳ���ʹ��һ��ɨ��ʵ����
 * @author baifeng
 *
 */
public class RemoveNthFromEnd {
	 public static ListNode removeNthFromEnd(ListNode head, int n) {
	        ListNode cur = head;
	        ListNode next = head;
	        while(n>0) {
	        	next = next.next;
	        	n--;
	        }
	        if(next==null) {
	        	return head.next;
	        }
	        while(next.next!=null) {
	        	cur = cur.next;
	        	next = next.next;
	        }
	   
	        cur.next = cur.next.next;
	        
	        return head;
	        
	    }
	 public static void printNode(ListNode head) {
		 while(head!=null) {
			 System.out.print(head.val);
			 head = head.next;
		 }
		 System.out.println();
	 }
	 public static void main(String[] args) {
		ListNode node  = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next =null;
		printNode(node);
		removeNthFromEnd(node, 1);
		printNode(node);
	}
}
