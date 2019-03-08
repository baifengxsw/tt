package cn.itcast10_list;
/**
 * 得到在多种情况下相交的第一个节点
 */
import java.util.HashSet;

public class FindFirstIntersectNode {
	public static class Node {
		public int value;
		public Node next ;
		public Node (int value) {
			this.value = value;
		}
	}
	
	public static Node getLoopNode1(Node head) {
		if(head == null||head.next ==null||head.next.next ==null)
			return null;
		Node fast = head.next.next;
		
		Node slow = head.next ;
		
		while(slow!=fast) {
			if(fast.next==null||fast.next.next==null) {
				
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = head;
		while(slow !=fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;

	}
	
	public static Node getLoopNode2(Node head) {
		if(head == null)
			return null;
		HashSet <Node> set = new HashSet<>();
		Node cur = head ;
		while(cur!=null) {
			if(set.contains(cur)) {
				return cur;
			}
			set.add(cur);
			cur = cur.next;
		}
		return null;
	}
	
	public static Node getInterserctNode(Node head1,Node head2) {
		if( head1 == null|| head2 ==null) {
			return null;
		}
		Node loop1 = getLoopNode1(head1);
		Node loop2 = getLoopNode1(head2);
		if(loop1==null && loop2==null) {
			return noLoop(head1,head2);
		}else if (loop1!=null && loop2!=null) {
			return bothLoop(head1, loop1, head2, loop2);
		}else {
			
			return null;
		}
	}

	public static Node noLoop(Node head1, Node head2) {
		if(head1==null ||head2 == null) {
			return null;
		}
		Node cur1 = head1 ;
		Node cur2 = head2 ;
		int n = 0;//n為兩者長度的差值
		//cur1.next!=null 最后得到是最后一个节点   如果是cur！=null  得到的是null
		while(cur1.next!=null) {
			n++;
			cur1=cur1.next;
		}
		while(cur2.next!=null) {
			n--;
			cur2 = cur2.next;
		}
		if(cur2!=cur1) {
			return null;
		}
		
		cur1 = n >0 ? head1 :head2;
		cur2 = cur1 ==head1? head2:head1;
		n = Math.abs(n);
		while(n>0) {
			n--;
			cur1=cur1.next;
		}
		while(cur1!=cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
		
	}
	public static Node bothLoop(Node head1 ,Node loop1,Node head2,Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		if(loop1==loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while(cur1!=loop1) {
				n++;
				cur1 = cur1.next;
			}
			while(cur2!=loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n>0 ? head1:head2;
			cur2 = cur1 == head1? head2:head1;
			n = Math.abs(n);
			while(n>0) {
				n--;
				cur1 = cur1.next;
			}
			while(cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
			
		}else {
			cur1 = loop1.next;
			while(cur1!=loop1) {
				if(cur1== loop2) {
					return loop1;
				}
				cur1=cur1.next;
			}
			return null;
		}
	}
	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getInterserctNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getInterserctNode(head1, head2).value);
		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getInterserctNode(head1, head2).value);

	}
}
