package cn.itcast02_simple_basic;

import cn.itcast10_list.CopyListWithRand.Node;
/**
 * 实现随机节点的复制
 * @author baifeng
 *
 */
public class ceshi {
	public static Node copyListWithRandom(Node head) {
		if(head==null)
			return null;
		//先进行节点的复制 1-1-2-2-3-3;
		Node cur = head;
		Node right = null;
		Node temp = null;
		while(cur!=null) {
			temp  = cur.next;
			cur.next= new Node(cur.value);
			cur.next.next=temp;
			cur = temp;
			
		}
		
		cur = head;
		
		while(cur!=null) {
			temp = cur.next.next;
			right = cur.next;
			right.rand= cur.rand ==null?null:cur.rand.next;
			cur = temp;
		}
		
		cur = head;
		Node ret = head.next;
		while(cur!=null) {
			temp = cur.next.next;
			right = cur.next;
			cur.next=temp;
			right.next = temp==null?null:temp.next;
			cur =temp;
		}
		return ret;
		
	}
	public static void printRandLinkedList(Node head) {
		Node cur = head;
		System.out.print("order: ");
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:  ");
		while (cur != null) {
			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = null;
		Node res1 = null;
		Node res2 = null;
		printRandLinkedList(head);
		res1 = copyListWithRandom(head);
		printRandLinkedList(res1);
		res2 = copyListWithRandom(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

		printRandLinkedList(head);
		System.out.println("=========================");
		
		res1 = copyListWithRandom(head);
		printRandLinkedList(res1);
		
		System.out.println("=========================");
		res2 = copyListWithRandom(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

	}
}
