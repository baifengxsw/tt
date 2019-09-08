package cn.itcast03_tanxin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * �����Ŀ�����ܶ�İ��� 
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
	//����Ŀ����ʱ���С�����������
	public static class NodeComparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			return o1.end - o2.end;
		}
		
	}
	//�����ܽ��������Ŀ�Ĵ��� cur ����ǰʱ��
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
	  System.out.println(Integer.valueOf("c",14));
	}

}
