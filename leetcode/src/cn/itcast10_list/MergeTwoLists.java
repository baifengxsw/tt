package cn.itcast10_list;
/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 * @author baifeng
 *
 */
public class MergeTwoLists {
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        
        while(l1!=null&&l2!=null) {
        	if(l1.val<l2.val) {
        	
        			tail.next  =l1;
        			l1= l1.next;
        	}else {
        		
        			tail.next = l2;
        			l2 = l2.next;
        	}
        	tail = tail.next;
        }
        tail.next = l1!=null ?l1:l2;
        return head.next;
    }
	/**
	 * 递归解法
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null)
			return l2;
		if(l2 ==null)
			return l1;
		ListNode head = l1.val< l2.val ?l1 :l2;
		ListNode next = l1.val<l2.val ?l2:l1;
		head.next = mergeTwoLists(head.next, next);
		return head;
		
	}
}
