package cn.itcast10_list;
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
	public boolean hasCycle(ListNode head) {
        if(head ==null||head.next==null)
        	return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(slow!=fast) {
        	if(fast.next==null||fast.next.next==null)
        		return false;
        	fast = fast.next.next;
        	slow = slow.next;
        }
        return true;
        
    }
}
