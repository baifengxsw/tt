package cn.itcast10_list;
/**
 * ���дһ��������ʹ�����ɾ��ĳ�������и����ģ���ĩβ���ڵ㣬�㽫ֻ������Ҫ��ɾ���Ľڵ㡣

����һ������ -- head = [4,5,1,9]�������Ա�ʾΪ:



 

ʾ�� 1:
˵��:

�������ٰ��������ڵ㡣
���������нڵ��ֵ����Ψһ�ġ�
�����Ľڵ�Ϊ��ĩβ�ڵ㲢��һ���������е�һ����Ч�ڵ㡣
��Ҫ����ĺ����з����κν����
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
