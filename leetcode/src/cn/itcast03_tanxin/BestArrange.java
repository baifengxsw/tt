package cn.itcast03_tanxin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 多个项目尽可能多的安排 
 * @author baifeng
 *
 */
public class BestArrange {
	public static class Node{
		public int start;
		public int end;
		public Node (int start,int end) {
			this .start = start;
			this.end = end;
		}
	}
	//以项目结束时间从小到大进行排序
	public static class NodeComparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			return o1.end - o2.end;
		}
		
	}
	//返回能进行最多项目的次数 cur 代表当前时间
	public static int bestArrange(Node [] nodes,int cur) {
		Arrays.sort(nodes, new NodeComparator());
		int res = 0;
		for(int i= 0;i<nodes.length;i++) {
			if(cur<=nodes[i].start) {
				res++;
				cur = nodes[i].end;
			}
		}
		return res;
		
	}
	public static void main(String[] args) {
		Node node1 = new Node(1,7);
		Node node2 = new Node(6,9);
		Node node3 = new Node(8,16);
		Node [] nodes = {node1,node2,node3};
		int res = bestArrange(nodes, 0);
		System.out.println("res:"+res);
	}

}
