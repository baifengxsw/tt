package cn.itacast_05_Tu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cn.itacast_05_Tu.GraphGenerator.Graph;
import cn.itacast_05_Tu.GraphGenerator.Node;



//求拓扑排序 ，前提 必定是有向图且无环的  queue linkedlist priorityqueue  
//像二叉树的层次遍历 ，这里必须需要一个队列
public class TopologySort {
	public static List<Node> sortedTopology(Graph graph){
		HashMap<Node,Integer> inMap = new HashMap<>();
		Queue<Node> zeroInList  = new LinkedList<>();
		for(Node node : graph.nodes.values()) {
			inMap.put(node, node.in);
			if(node.in == 0) {
				zeroInList.add(node);
				
			}
		}
		List<Node> list = new ArrayList<>();
		while(!zeroInList.isEmpty()) {
			Node cur = zeroInList.poll();
			list.add(cur);
			for(Node next:cur.nexts) {
				inMap.put(next,inMap.get(next)-1);
				if(inMap.get(next)==0) {
					zeroInList.add(next);
				}
			}
		}
		return list;
	}

}
