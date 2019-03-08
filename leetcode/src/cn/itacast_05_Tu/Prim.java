package cn.itacast_05_Tu;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import cn.itacast_05_Tu.GraphGenerator.Edge;
import cn.itacast_05_Tu.GraphGenerator.Graph;
import cn.itacast_05_Tu.GraphGenerator.Node;



public class Prim {
	public static class EdgeComparator implements Comparator<Edge>{

		@Override
		public int compare(Edge o1, Edge o2) {
			// TODO 自动生成的方法存根
			return o1.weight - o2.weight;
		}
	
	}
	
	public static Set<Edge> primMST(Graph graph) {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		HashSet<Edge> res = new HashSet<>();
		HashSet<Node> set = new HashSet<>();
		for(Node node :graph.nodes.values()) {
			if(!set.contains(node)) {
				set.add(node);
				for(Edge edge:node.edges) {
					queue.add(edge);
				}
				while(!queue.isEmpty()) {
					Edge edge = queue.poll();
					if(!set.contains(edge.to)) {
						res.add(edge);
						set.add(edge.to);
						for(Edge nextEdge:edge.to.edges) {
							queue.add(nextEdge);
						}
						
					}
				}
			}
		}
		return res;
	}
}
