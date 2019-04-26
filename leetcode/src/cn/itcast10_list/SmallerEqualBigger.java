package cn.itcast10_list;

import java.util.HashMap;

/**
 * 将链表划分为 左小 中间相等 ，右边大的
 * @author baifeng
 *
 */
public class SmallerEqualBigger {
	public static class Node{
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
		}
		public static Node listPartition1(Node head,int pivot) {
			if(head == null) {
				return null;
			}
			Node cur = head ;
			int num = 0 ;
			while(cur!=null) {
				num++;
				cur = cur.next;
			}
			Node [] nodeArray = new Node [num];
			cur = head;
			int i ;
			for( i = 0 ;i<num;i++) {
				nodeArray[i] = cur;
				cur = cur.next;
			}
			arrPartition(nodeArray,pivot);
			
			for( i =1 ;i<num;i++) {
				nodeArray[i-1].next = nodeArray[i];
			}
				nodeArray[i-1].next=null;
				return nodeArray[0];
		}
		public static void arrPartition(Node[] nodeArray, int pivot) {
			// TODO 自动生成的方法存根
			int less = -1;
			int more = nodeArray.length;
			int index = 0;
			while(index<more) {
				if(nodeArray[index].value<pivot) {
					swap(nodeArray,index++,++less);
					
				}else if( nodeArray[index].value >pivot) {
					swap(nodeArray,index,--more);
				}else {
					index++;
				}
			}
		}
		public static void swap(Node[] nodeArray, int i, int j) {
			// TODO 自动生成的方法存根
			Node temp = nodeArray[i];
			nodeArray[i] = nodeArray[j];
			nodeArray[j] = temp;
		}
		
		public static Node listPartition2(Node head, int pivot) {
			Node sH = null; // small head
			Node sT = null; // small tail
			Node eH = null; // equal head
			Node eT = null; // equal tail
			Node bH = null; // big head
			Node bT = null; // big tail
			Node next = null; // save next node
			Node cur = head;
			// every node distributed to three lists
			while (cur != null) {
				next = cur.next;
				cur.next = null;
				if (cur.value < pivot) {
					if (sH == null) {
						sH = cur;
						sT = cur;
					} else {
						sT.next = cur;
						sT = cur;
					}
				} else if (cur.value == pivot) {
					if (eH == null) {
						eH = cur;
						eT = cur;
					} else {
						eT.next = cur;
						eT = cur;
					}
				} else {
					if (bH == null) {
						bH = cur;
						bT = cur;
					} else {
						bT.next = cur;
						bT = cur;
					}
				}
				cur = next;
			}
			// small and equal reconnect
			/**
			 * 重要哦
			 */
			if (sT != null) {
				sT.next = eH;
				eT = eT == null ? sT : eT;
			}
			// all reconnect
			if (eT != null) {
				eT.next = bH;
			}
			return sH != null ? sH : eH != null ? eH : bH;
		}

		public static void printLinkedList(Node node) {
			System.out.print("Linked List: ");
			while (node != null) {
				System.out.print(node.value + " ");
				node = node.next;
			}
			System.out.println();
		}

		public static void main(String[] args) {
			Node head1 = new Node(7);
			head1.next = new Node(9);
			head1.next.next = new Node(1);
			head1.next.next.next = new Node(8);
			head1.next.next.next.next = new Node(5);
			head1.next.next.next.next.next = new Node(2);
			head1.next.next.next.next.next.next = new Node(5);
			printLinkedList(head1);
			// head1 = listPartition1(head1, 4);
			head1 = listPartition1(head1, 5);
			printLinkedList(head1);
	
		}

	}
	
	
}
