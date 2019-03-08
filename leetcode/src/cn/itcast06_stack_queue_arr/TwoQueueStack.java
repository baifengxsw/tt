package cn.itcast06_stack_queue_arr;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {
	private Queue<Integer> queue;
	private Queue<Integer> help;
	
	public TwoQueueStack() {
		queue = new LinkedList<Integer>();
		help = new LinkedList<Integer>();
	}
	public void push(int newNum) {
		queue.add(newNum);
	}
	public int peek() {
		if(queue.isEmpty())
			throw new RuntimeException("The stack is empty");
		while(queue.size()>1) {
			help.add(queue.poll());
		}
		int res = queue.poll();
		help.add(res);
		swap();
		return res;
		
	}
	public int pop() {
		if(queue.isEmpty())
			throw new RuntimeException("The stack is empty");
		while(queue.size()>1) {
			help.add(queue.poll());
		}
		int res = queue.poll();
		
		swap();
		return res;
		
	}
	public void swap() {
		Queue<Integer> tmp = help;
		help = queue;
		queue = tmp;
	}
}
