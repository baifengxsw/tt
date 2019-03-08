package cn.itcast06_stack_queue_arr;

public class ArrayQueue {
	private Integer[] arr;
	private Integer size ;
	private Integer end;
	private Integer start;
	
	public ArrayQueue(int initsize) {
		if(initsize <0) {
			throw new IllegalArgumentException("The init size is less than 0");
			
			
		}
		arr = new Integer[initsize];
		start = 0;
		end = 0;
		size = 0;
		
	}
	public Integer peek() {
		if(size == 0) {
			return null;
		}
		return arr [start];
	}
	public void push(int obj) {
		if(size == arr.length)
			throw new ArrayIndexOutOfBoundsException("The queue is full");
		size ++;
		arr[end]= obj;
		end = (end+1)%arr.length;
	}
	
	public Integer poll() {
		if(size ==0)
			throw new ArrayIndexOutOfBoundsException("The queue is empty");
		size --;
		int tmp = start;  
		start = (start+1)%arr.length;
		return arr[tmp];
	}
}
