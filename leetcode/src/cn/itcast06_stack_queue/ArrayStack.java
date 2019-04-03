package cn.itcast06_stack_queue;

public class ArrayStack {
	private Integer [] arr;
	private Integer index;// µ±«∞÷∏’Î
	
	public ArrayStack(int initsize) {
		if(initsize < 0 ) {
			throw new IllegalArgumentException("The init size is less than 0 ");
		}
		arr = new Integer[initsize];
		index = 0;
	}
	
	public Integer peek() {
		if(0==index)
			return null;
		return arr [index -1];
	}
	public void push(int obj) {
		if(index == arr.length) {
			throw new ArrayIndexOutOfBoundsException(" The stack is full");
			
		}
		arr[index++] = obj;
		
	}
	
	public Integer pop() {
		if(index == 0) {
			throw new ArrayIndexOutOfBoundsException("The stack is empty");
		}
		return arr[--index];
	}
}


