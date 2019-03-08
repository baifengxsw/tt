package cn.itacast_05_Tu;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import cn.itacast_05_Tu.GraphGenerator.Edge;
import cn.itacast_05_Tu.GraphGenerator.Graph;
import cn.itacast_05_Tu.GraphGenerator.Node;



public class Kruskal {
	public static class UnionFind{
		private HashMap<Node,Node> inMap ;
		private HashMap<Node,Integer> sizeMap;
		
		public UnionFind(Collection<Node> nodes) {
			inMap  = new HashMap<>();
			sizeMap = new HashMap<>();
			initUnion(nodes);
		}
		//因为这边是堆栈的空间 ，所以要及时的清空
		private void initUnion(Collection<Node>nodes) {
			
			for(Node node :nodes) {
				inMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}
		/*******/
		public Node getFather(Node node) {
			Node father = inMap.get(node);
			if(father!=node) {
				father = getFather(father);
			}
			inMap.put(node, father);
			return father;
		}
		
		public boolean isSameSet(Node a, Node b) {
			return getFather(a)==getFather(b);
		}
		
		public void Union(Node a, Node b) {
			if(a == null|| b ==null) {
				return ;
			}
			Node ad = getFather(a);
			Node bd = getFather(b);
			if(ad == bd)
				return ;
			int adSize = sizeMap.get(ad);
			int bdSize = sizeMap.get(bd);
			if(adSize >bdSize) {
				inMap.put(bd,ad);
				sizeMap.put(ad, adSize+bdSize);
			}else {
				inMap.put(ad, bd);
				sizeMap.put(bd,adSize+bdSize);
			}
			
		}
	}
	public static class EdgeComparator implements Comparator<Edge>{

		@Override
		public int compare(Edge o1, Edge o2) {
			// TODO 自动生成的方法存根
			return o1.weight - o2.weight;
		}
		
	}
	
	public static Set<Edge> kruskalMST(Graph graph){
		PriorityQueue<Edge> queue = new PriorityQueue<>(new EdgeComparator());
		UnionFind unionFind = new UnionFind(graph.nodes.values());
		for(Edge edge :graph.edges) {
			queue.add(edge);
		}
		HashSet<Edge> res = new HashSet<>();
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			if(!unionFind.isSameSet(cur.from, cur.to)) {
				res.add(cur);
				unionFind.Union(cur.from, cur.to);
			}
		}
		return res;
	}
}
