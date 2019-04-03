package cn.itcast06_stack_queue;

import java.util.Stack;

/**
 * 解决压入 弹出 min 都是O（1）
 * @author baifeng
 *
 */
public class MyStack {
	public static class Mystack2{
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;
		
		
		public Mystack2() {
			stackData = new Stack<Integer>();
			stackMin = new Stack<Integer>();
		}
		public void push(int newNum) {
			if(stackMin.isEmpty()) {
				stackMin.push(newNum);
			}else if(newNum <getmin()) {
				this.stackMin.push(newNum);
			}else{
				int newMin = stackMin.peek();
				stackMin.push(newMin);
			}
			stackData.push(newNum);
		}
		
		public int pop() {
			if(stackData.isEmpty())
				throw new RuntimeException("Your stack is empty");
			 stackMin.pop();
			 return stackData.pop();
		}
		public int getmin() {
			if(stackMin.isEmpty())
				throw new RuntimeException("Your stack is empty");
			return stackMin.peek();
		}
	}
}
