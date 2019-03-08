package cn.itcast10_list;

import java.util.HashMap;

public class CopyListWithRand {
	public static class Node{
		public int value;
		public Node next;
		public Node rand;
		public Node(int value) {
			this.value = value;
		}
		
	}
	public static Node copyListWithRand1(Node head) {
		HashMap<Node, Node> map = new HashMap<>();
		Node cur = head;
		while(cur!=null) {
			map.put(cur,new Node(cur.value));
			cur = cur.next;
		}
		cur = head ;
		while(cur!=null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(head);
	}
	
	public static Node copyListWithRand2(Node head) {
		if( head == null)
			return null;
		Node cur = head ;
		Node next = null;
		while(cur!=null) {
			next = cur.next;
			cur.next  = new Node(cur.value);
			cur.next.next = next;
			cur = next;
		}
		//上面是对链表的复制
		cur = head;
		Node copyCur = null;
		while(cur!=null) {
			next = cur.next.next;
			copyCur= cur.next;
			copyCur.rand =cur.rand == null ? null:cur.rand.next;
			cur= next;

		}
		//下面是对链表的拆分
		cur = head ;
	    Node ret = head.next;

		while(cur!=null) {
			next = cur.next.next;
			copyCur = cur.next;
			cur.next =next;
			copyCur.next = next==null? null :next.next;
			cur = next;
			
			
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
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
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
		
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		
		System.out.println("=========================");
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

	}
}
