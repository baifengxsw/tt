package cn.itcast02_simple_basic;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * ���������ֵ �����ʹ������ ����ô����ض�ΪO��nlogn�� ʹ�ö�ȡ���ֵ������
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
				// TODO �Զ����ɵķ������
				return o1.c - o2.c;
			}
		});
		
		PriorityQueue<Node> profitHeap = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO �Զ����ɵķ������
				return o2.p - o1.p;
			}
		});
		
		//��ʼ��cost ��С��
		for(int i = 0 ;i <nodeArr.length ;i++) {
			costHeap.add(nodeArr[i]);
		}
		
		//��profit ������� 
		for(int i = 0 ;i<k;i++) {
			//���ұ߼��������㵱ǰ�ʽ����Ŀ ѡ������
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
