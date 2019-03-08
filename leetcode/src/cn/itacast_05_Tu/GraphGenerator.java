package cn.itacast_05_Tu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 * 图的基础结构 ，满足所有的需求 
 * @author baifeng
 *
 */
public class GraphGenerator {
	public class Node {
		public int value ;
		public int in ;
		public int out;
		public ArrayList<Node> nexts;
		public ArrayList<Edge> edges;
		
		public Node(int value) {
			this.value = value;
			in = 0;
			out= 0;
			nexts = new ArrayList<>();
			edges = new ArrayList<>();
			
		}
	}
		
		public class Edge{
			public int weight;
			public Node from;
			public Node to;
			
			public Edge(int weight ,Node from ,Node to) {
				this.weight = weight;
				this.from = from;
				this.to= to;
				
			}
			
		}
		public class Graph{
			public HashMap<Integer,Node> nodes;
			public HashSet<Edge> edges;
			public Graph() {
				nodes = new HashMap<>();
				edges = new HashSet<>();
			}
		}
		public Graph createGraph(int [][] matrix) {
			Graph graph = new Graph();
			for(int i = 0; i<matrix.length;i++) {
				int weight = matrix[i][0];
				int from = matrix[i][1];
				int to = matrix[i][2];
				if(!graph.nodes.containsKey(from)) {
					graph.nodes.put(from, new Node(from));
					
				}
				if(!graph.nodes.containsKey(to)) {
					graph.nodes.put(to, new Node(to));
				}
				Node fromNode = graph.nodes.get(from);
				Node toNode = graph.nodes.get(to);
				fromNode.out++;
				fromNode.nexts.add(toNode);
				toNode.in++;
				Edge newedge = new Edge(weight,fromNode,toNode);
				fromNode.edges.add(newedge);
				graph.edges.add(newedge);
			}
			return graph;
		}
	
	}

