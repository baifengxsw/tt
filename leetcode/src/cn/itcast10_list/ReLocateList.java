package cn.itcast10_list;

import java.util.HashMap;

/**
 * 按一定的规则调整链表
 * @author baifeng
 *
 */
public class ReLocateList {
	public static class Node{
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
		}
	}
	public static void reLocateList(Node head) {
		HashMap<String ,Integer> map = new HashMap<>();
		map.put("xia", map.get("xia")+1);
		System.out.println(map.get("xia"));
		if(head==null||head.next ==null) {
			return ;
		}
		Node left = head;
		Node right = head.next;
		while(right.next!=null&&right.next.next!=null) {
			left = left.next;
			right = right.next.next;
		}
		right = left.next;
		left.next = null;
	    midLR(head,right);
		
	}
	
	public static void reLocate(Node head) {
		if(head==null || head.next ==null) {
			return ;
		}
		int i = 0;
		Node cur = head;
		while(cur!=null) {
			i++;
			cur = cur.next;
		}
		int arr [] = new int [i];
		cur = head;
		i=0;
		while(cur!=null) {
			arr[i]= cur.value;
			i++;
			cur =cur.next;
		}
		int res[] = new int [arr.length];
		int mid = (arr.length-1)/2;
		if(arr.length %2 ==0) {
			for(int j = 0;j<arr.length;j++) {
				if(j<=mid) {
					res[2*j]= arr[j];
				}else {
					res[(j-mid-1)*2+1] = arr[j];
				}
			}
		}else {
			for(int j = 0;j<arr.length-1;j++) {
				if(j<mid) {
					res[2*j]= arr[j];
				}else {
					res[(j-mid)*2+1] = arr[j];
				}
			}
			res[arr.length-1]= arr[arr.length-1];
			
		}
		head = new Node(res[0]);
		Node start = head;
	  for(int k = 1 ;k<arr.length;k++) {
		  head.next = new Node(res[k]);
		  head = head.next;
	  }
	  head.next=null;
	  head = start;
		
		
	}


	private static void midLR(Node left, Node mid) {
		Node next = null;
		while(left.next!=null) {
			next = mid.next;
			mid.next = left.next;
			left.next = mid;
			left = mid.next;
			mid = next;
		}
		left.next = mid;

}	
	public static void printLinkedList(Node head) {
	System.out.print("Linked List: ");
	while (head != null) {
		System.out.print(head.value + " ");
		head = head.next;
	}
	System.out.println();
}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next =null;
		printLinkedList(head);
		reLocate(head);
		printLinkedList(head);
		
	}
}
