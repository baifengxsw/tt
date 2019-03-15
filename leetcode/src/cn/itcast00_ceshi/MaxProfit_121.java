package cn.itcast00_ceshi;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�

��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������

ע���㲻���������Ʊǰ������Ʊ��

ʾ�� 1:

����: [7,1,5,3,6,4]
���: 5
����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
     ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�
 * @author baifeng
 *
 */

public class MaxProfit_121 {
	public static class Node{
		int index ;
		int value ;
		public Node(int index, int value) {
			
			this.index = index;
			this.value = value;
		}
	}
	public static int maxProfit1(int[] prices) {
	       PriorityQueue<Node> cost = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO �Զ����ɵķ������
				return o1.value - o2.value;
			}
		});
	       PriorityQueue<Node> profit = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO �Զ����ɵķ������
				return o2.value - o1.value;
			}
		});
	       for(int i = 0 ;i<prices.length;i++) {
	    	   Node node = new Node(i, prices[i]);
	    	   cost.add(node);
	    	   profit.add(node);
	       }
	       int res = 0;
	       Node [] nodes = new Node [profit.size()];
	       while(!cost.isEmpty()) {
	    	   Node minNode = cost.poll();
	    	   
	    	   nodes = profit.toArray(nodes);
	    	   for(int i = 0;i<nodes.length;i++) {
	    		   if(nodes[i].value>minNode.value&&nodes[i].index>minNode.index) {
	    			   res = Math.max(res,nodes[i].value - minNode.value);
	    		   }
	    	   }
	       }
	       return res;
	    
	}
	
	public static void main(String[] args) {
		int prices [] = {3,2,6,5,0,3};
		int res = maxProfit(prices);
		System.out.println(res);
		
	}
	/**
	 * leetcode
	 * 
	 * @param prices
	 * @return
	 */

	private static int maxProfit(int[] prices) {
		if(prices == null)
			return 0;
		int minIndex = 0;
		int maxprofit = Integer.MIN_VALUE;
		for(int i =0;i<prices.length;i++) {
			if(prices[i] <prices[minIndex])
				minIndex = i;
			if(prices[i]-prices[minIndex]>maxprofit) {
				maxprofit = prices[i] - prices[minIndex];
			}
		}
		return maxprofit;
	}
}
