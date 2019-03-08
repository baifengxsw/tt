package cn.itcast02_simple_basic;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 多项工作最大价值 ，如果使用排序 ，那么结果必定为O（nlogn） 使用堆取最大值是最方便的
 * @author baifeng
 *
 */

public class CostProfit {
	public class Node{
		int p;
		int c;
		public Node (int c,int p) {
			this.p = p;
			this.c = c;
		}
	}
	
	public  int costProfit(int k, int w,int [] cost,int [] profit) {
		Node [] nodeArr = new Node [cost.length];
		for (int i=0;i<nodeArr.length;i++) {
			nodeArr[i].c = cost[i];
			nodeArr[i].p = profit[i];
			
		}
		PriorityQueue<Node> costHeap = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare( Node o1, Node o2) {
				// TODO 自动生成的方法存根
				return o1.c - o2.c;
			}
		});
		
		PriorityQueue<Node> profitHeap = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO 自动生成的方法存根
				return o2.p - o1.p;
			}
		});
		
		//初始化cost 最小堆
		for(int i = 0 ;i <nodeArr.length ;i++) {
			costHeap.add(nodeArr[i]);
		}
		
		//向profit 堆中添加 
		for(int i = 0 ;i<k;i++) {
			//像右边加入多个满足当前资金的项目 选择最大的
			while(!costHeap.isEmpty()&&costHeap.peek().c<=w) {
				profitHeap.add(costHeap.poll());
			}
			if(profitHeap.isEmpty())
				return w;
			w += profitHeap.poll().p;
		}
		return w;
		
	}
}
