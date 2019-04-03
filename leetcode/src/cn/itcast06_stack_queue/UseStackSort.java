package cn.itcast06_stack_queue;

import java.util.Stack;

/**
 * 使用一个辅助栈对另一个栈进行排序
 * @author baifeng
 *
 */
public class UseStackSort {
	public static void sortStack(Stack<Integer> stack) {
		if(stack ==null ||stack.size()==1||stack.isEmpty()) {
			return ;
		}
		Stack<Integer> help = new Stack<>();
	
		
		help.push(stack.pop());
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			while(!help.isEmpty()&&temp>help.peek()) {
				int cha = help.pop();
				stack.push(cha);
			}
			help.push(temp);
			
			
		}
		while(!help.isEmpty()) {
			stack.push(help.pop());
		}
		
	}
}
