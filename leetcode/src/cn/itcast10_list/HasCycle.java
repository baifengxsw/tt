package cn.itcast10_list;

import cn.itcast10_list.FindFirstIntersectNode.Node;

/**
 * ����һ�������ж��������Ƿ��л���

Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���

 

ʾ�� 1��

���룺head = [3,2,0,-4], pos = 1
�����true
���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
 * @author baifeng
 *
 */
public class HasCycle {
	public static boolean  hasCycle(Node head) {
        if(head ==null||head.next==null||head.next.next==null)
        	return false;
        Node fast = head.next.next;
        Node slow = head.next;
        while(slow!=fast) {
        	if(fast.next==null||fast.next.next==null)
        		return false;
        	fast = fast.next.next;
        	slow = slow.next;
        }
        return true;
        
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
		System.out.println(hasCycle(head1));
		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(hasCycle(head2));

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
		System.out.println(hasCycle(head1));
		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = null; // 8->2
		System.out.println(hasCycle(head2));
		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = null;// 8->6
		System.out.println(hasCycle(head2));

	}
}
