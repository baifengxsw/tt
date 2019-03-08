package cn.itcast02_simple_basic;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;



public class UnionFind {
	public class Data{
		
	}
	public class UnionFindAll{
		//fatherMap<data1,data2> data2 是data1的父节点 ，向上更新的时候进行改变
		HashMap<Data,Data> fatherMap ;
		HashMap<Data,Integer> sizeMap ;
		
		public UnionFindAll(List<Data>list) {
			fatherMap = new HashMap<>();
			sizeMap = new HashMap<>();
			//初始化
			initUnion(list);
		}

		private void initUnion(List<Data> list) {
			// TODO 自动生成的方法存根
			fatherMap.clear();
			sizeMap.clear();
			for(Data data:list) {
				fatherMap.put(data, data);
				sizeMap.put(data, 1);
			}
		}
		/************************/
		public Data getDaibiao(Data data) {
//			Data father = fatherMap.get(data);
//			if(data!=father) {
//				father = getDaibiao(father);
//			}
//			fatherMap.put(data, father);
//			return father;
			Stack<Data> stack = new Stack<>();
			Data cur = data;
			Data parent = fatherMap.get(data);
			while(cur!=parent) {
				stack.push(cur);
				cur = parent;
				parent = fatherMap.get(cur);
			}
			while(!stack.isEmpty()) {
				fatherMap.put(stack.pop(), parent);
			}
			return parent;
		}
		
		public boolean isSameSet(Data a, Data b) {
			return getDaibiao(a)==getDaibiao(b);
		}
		
		public void union(Data a ,Data b) {
			if(a == null || b == null) {
				return ;
			}
			Data ad = getDaibiao(a);
			Data bd = getDaibiao(b);
			int adSize = sizeMap.get(ad);
			int bdSize = sizeMap.get(bd);
			if(ad!=bd) {
			if(adSize <= bdSize) {
				fatherMap.put(ad, bd);
				sizeMap.put(bd, adSize + bdSize);
			}else {
				fatherMap.put(bd, ad);
				sizeMap.put(ad,adSize + bdSize);
			}
		}
	}}
}
