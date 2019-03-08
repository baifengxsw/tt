package cn.itcast06_stack_queue_arr;

import java.util.HashMap;
import java.util.Set;

/**
 * 找到数组中任意两个数的和 为给定值 ，并且 返回相应的索引
 * @author baifeng
 *
 */
public class TwoNumSum {
	public static void  heap(int [] arr ,int []index) {
		if(arr == null||index == null)
			return ;
		//初始化大根堆
		for(int i= 0;i<arr.length;i++) {
			heapInsert(arr,i,index);
		}
		int size = arr.length;
		swap(arr,0,--size);
		swap(index,0,size);
		while(size>0) {
			heapify(arr,0,--size,index);
			swap(arr,0,size);
			swap(index,0,size);
		}
		
	}

	private static void heapify(int[] arr, int i, int size, int[] index) {
		int left = i*2+1;
		while(left<=size) {
			int lagest = left+1<=size&&arr[left]<arr[left+1]? left+1:left;
			lagest = arr[lagest]<arr[i]? i:lagest;
			if(lagest==i) {
				break;
			}
			swap(arr,i,lagest);
			swap(index,i,lagest);
			i = lagest;
			left = 2*i+1;
		}
		
	}

	private static void heapInsert(int[] arr, int i,int []index) {
		while(arr[i]>arr[(i-1)/2]) {
			swap(arr,i,(i-1)/2 );
			swap(index,i,(i-1)/2);
			i=(i-1)/2;
		}
		
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO 自动生成的方法存根
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int [] findTwoIndex(int []arr, int []index,int sum) {
		int less = 0;
		int more = arr.length-1;
		while(less<=more) {
			int add = arr[less] +arr[more];
			if(add ==sum) {
				return new int[] {index[less],index[more]}; 
			}else if(add<sum) {
				less++;
			}else {
				more--;
			}
		}
		return null;
	}
	/**
	 * 使用hash表的方式 
	 * @param args
	 */
	public static int[] findTwoIndex1(int [] arr,int sum) {
		if(arr ==null)
		return null;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i =0;i<arr.length;i++) {
			map.put(arr[i],i);
		}
		Set<Integer> set = map.keySet();
		for(int key :set) {
			if(key<sum &&map.containsKey(sum-key)) {
				return new int[] {map.get(key),map.get(sum-key)};
			}
		}
		return null;
	}
	public static void main(String[] args) {
		int arr[] = {10,2,5,9,2,17};
		int index[] = new int[arr.length];
		for(int i = 0;i<arr.length;i++ ) {
			index[i]=i;
		}
		heap(arr, index);
		int [] res = findTwoIndex(arr, index, 13);
		int [] res1 = findTwoIndex1(arr,13);
		System.out.println("index:"+res[0]+"index:"+res[1]);
		System.out.println("index1:"+res1[0]+"index1:"+res1[1]);
		
	}
}
