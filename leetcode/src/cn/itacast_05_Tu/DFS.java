package cn.itacast_05_Tu;

import java.util.HashSet;
import java.util.Stack;

import cn.itacast_05_Tu.GraphGenerator.Node;



public class DFS {
	public static void DFS(Node node) {
		if(node == null) {
			return ;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		System.out.println(node.value+" ");
		Node cur =null;
		while(!stack.isEmpty()) {
			cur = stack.pop();
			for(Node next:cur.nexts) {
				if(!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					System.out.println(next.value+" ");
					set.add(next);
					//每次添加一个所以
					break;
				}
			}
		}
		
	}

}
