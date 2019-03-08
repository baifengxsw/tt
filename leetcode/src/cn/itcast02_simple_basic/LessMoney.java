package cn.itcast02_simple_basic;

import java.util.PriorityQueue;

/**
 * 分金条 ，取最小的代价 ，哈夫曼编码
 * @author baifeng
 *
 */
public class LessMoney {
	public static int lessMoney (int arr []) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int i = 0 ;i<arr.length ;i++) {
			minHeap.add(arr[i]);
		}
		int cur = 0;
		int sum = 0;
		while(minHeap.size()>1) {
			cur = minHeap.poll() + minHeap.poll();
			sum += cur;
			minHeap.add(cur);
		}
		return sum ;
	}
	public static void main(String[] args) {
		int arr [] = { 10,20,30};
		int res = lessMoney(arr);
		System.out.println("res:"+res);
	}
}
