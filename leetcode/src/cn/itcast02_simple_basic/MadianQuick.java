package cn.itcast02_simple_basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 中位数就是排序好的中间数 
 * 在大根堆中添加较小的数 ，在小根堆中添加较大的数 
 * 
 * @author baifeng
 *
 */

public class MadianQuick {
	
	public static class MadianHolder {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new MinHeapComparator());
		
		private  void bothMod() {
			if(maxHeap.size()== minHeap.size()+2) {
				minHeap.add(maxHeap.poll());
			}
			if(minHeap.size() == maxHeap.size()+2) {
				maxHeap.add(minHeap.poll());
			}
		}
		
		public void addNum(int num) {
			if(maxHeap.isEmpty()) {
				maxHeap.add(num);
				return ;
			}
			if(maxHeap.peek()>=num) {
				maxHeap.add(num);
			}else {
				if(minHeap.isEmpty()) {
					minHeap.add(num);
					return ;
				}
				if(minHeap.peek()>num) {
					maxHeap.add(num);
				}else {
					minHeap.add(num);
				}
			}
			bothMod();
		}
		public Integer getMedian() {
			int maxHeapSize  = maxHeap.size();
			int minHeapSize  = minHeap.size();
			if(minHeapSize + maxHeapSize == 0)
				return null;
			Integer maxHeapHead = maxHeap.peek();
			Integer minHeapHead = minHeap.peek();
			
			if(((minHeapSize + maxHeapSize)&1)==0) {
				return (maxHeapHead + minHeapHead)/2;
			}
			return  maxHeapSize > minHeapSize ? maxHeapHead: minHeapHead;
			
		}
	}
	
	public static class MaxHeapComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO 自动生成的方法存根
			return o2 - o1;
		}
		
	}
	
	public static class MinHeapComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO 自动生成的方法存根
			return  o1 - o2;
		}
	}
	//得到随机长度 随机数组的数
	public static int[] getRandomArray(int maxLen, int maxValue) {
		int[] res = new int[(int) (Math.random() * maxLen) + 1];
		for (int i = 0; i != res.length; i++) {
			res[i] = (int) (Math.random() * maxValue);
		}
		return res;
	}

	// for test, this method is ineffective but absolutely right
	public static int getMedianOfArray(int[] arr) {
		int[] newArr = Arrays.copyOf(arr, arr.length);
		Arrays.sort(newArr);
		int mid = (newArr.length - 1) / 2;
		if ((newArr.length & 1) == 0) {
			return (newArr[mid] + newArr[mid + 1]) / 2;
		} else {
			return newArr[mid];
		}
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		boolean err = false;
		int testTimes = 1000;
		for (int i = 0; i != testTimes; i++) {
			int len = 30;
			int maxValue = 1000;
			int[] arr = getRandomArray(len, maxValue);
			MadianHolder medianHold = new MadianHolder();
			for (int j = 0; j != arr.length; j++) {
				medianHold.addNum(arr[j]);
			}
			if (medianHold.getMedian() != getMedianOfArray(arr)) {
				err = true;
				printArray(arr);
				break;
			}
		}
		System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");

	}

}
