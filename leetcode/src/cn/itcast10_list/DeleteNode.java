package cn.itcast10_list;
/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

现有一个链表 -- head = [4,5,1,9]，它可以表示为:



 

示例 1:
说明:

链表至少包含两个节点。
链表中所有节点的值都是唯一的。
给定的节点为非末尾节点并且一定是链表中的一个有效节点。
不要从你的函数中返回任何结果。
 * @author baifeng
 *
 */
public class DeleteNode {
	
	 
	 public void deleteNode(ListNode node) {
		 ListNode next = node.next;
		 node.val = next.val;
		 node.next = next.next;
		 next.next = null;
	 }
}
