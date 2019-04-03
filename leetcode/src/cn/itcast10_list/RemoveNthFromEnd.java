package cn.itcast10_list;
/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
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
