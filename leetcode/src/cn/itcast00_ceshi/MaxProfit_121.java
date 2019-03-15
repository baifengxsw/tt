package cn.itcast00_ceshi;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格
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
				// TODO 自动生成的方法存根
				return o1.value - o2.value;
			}
		});
	       PriorityQueue<Node> profit = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO 自动生成的方法存根
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
