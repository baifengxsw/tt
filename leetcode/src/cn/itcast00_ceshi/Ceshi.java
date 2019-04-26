package cn.itcast00_ceshi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import cn.itcast10_list.ListNode;
import cn.itcast10_list.IsPalindromeList.Node;
/**
 * 实现链表的就地逆置
 * @author baifeng
 *
 */
public class Ceshi {
		public static ListNode reverseList(ListNode head) {
			if(head==null||head.next==null)
				return head;
			ListNode cur = head ;
			ListNode right = head.next;
			cur.next=null;
			ListNode temp = null;
			while(right!=null) {
				temp = right.next;
				right.next=cur;
				cur =right;
				right = temp;
			}
			return cur;
		}
		public static void print(ListNode head) {
			while(head !=null) {
				System.out.print(head.val);
				head = head.next;
			}
			System.out.println();
		}
		public static void main(String[] args) {
			ListNode node1 = new ListNode(1);
			ListNode node2 = new ListNode(2);
			ListNode node3 = new ListNode(3);
			ListNode node4 = new ListNode(4);
			ListNode node5 = new ListNode(5);
			node1.next = node2;
			node2.next = node3;
			node3.next  = node4;
			node4.next = node5 ;
			node5.next = null;
			print(node1);
			ListNode head  = reverseList(node1);
			print(head);
			
		}
}
