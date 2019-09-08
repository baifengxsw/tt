package cn.itcast.gaoji;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	
	public static List<List<String>>getPath(String start ,String end , List<String> list){
		List<List<String>> result = null;
		
		
		
		HashMap<String ,ArrayList<String>> nexts = getNexts(list);
		
		HashMap<String,Integer> distance = getDistance(start,end,nexts);
		LinkedList<String> pathList = new LinkedList<>();
		return process(start,end ,distance,nexts,pathList ,result);
	}

	private static List<List<String>> process(String start, String end, HashMap<String, Integer> distance,
			HashMap<String, ArrayList<String>> nexts, LinkedList<String> path,List<List<String>> res) {
	     path.add(start);
	    if(start .equals(end )) {
	    	res.add(new ArrayList<>(path));
	    }else {
	    	 for(String next : nexts.get(start)) {
	    		 if(distance.get(next) == distance.get(start)+1) {
	    			 process(next, end, distance, nexts, path,res);
	    		 }
	    		
	    	}
	    }
	    path.pollLast();
		
		return null;
	}

	private static HashMap<String, Integer> getDistance(String start, String end,
			HashMap<String, ArrayList<String>> nexts) {
		Queue<String> queue = new LinkedList<>();
		HashSet<String> set  = new HashSet<>();
		HashMap<String ,Integer> distance = new HashMap<>();
		queue.add(start);
		set.add(start);
		distance.put(start, 0);
		while(!queue.isEmpty()) {
			String value = queue.poll();
			for(String cur : nexts.get(value)) {
				if(!set.contains(cur)) {
					queue.add(cur);
					set.add(cur);
					distance.put(cur, distance.get(value)+1);
				}
			}
		}
		return distance;
	}

	private static HashMap<String, ArrayList<String>> getNexts(List<String> list) {
	    
	    HashMap<String,ArrayList<String>> map = new HashMap<>();
	    for(int i = 0;i<list.size();i++) {
	    	map.put(list.get(i), new ArrayList<>());
	    }
	    
	    for(int i=0;i<list.size();i++) {
	    	map.put(list.get(i), getNext(list.get(i),list));
	    }
		return null;
	}

	private static ArrayList<String> getNext(String cur, List<String> list) {
		ArrayList<String> res = new ArrayList<>();
	    char [] curarr = cur.toCharArray();
	    char [] beifeng = cur.toCharArray();
	    for(char i = 'a';i<'z';i++) {
	    	for(int j = 0 ;j<curarr.length;j++) {
	    		if(curarr[j]!= i) {
	    			curarr[j] = i;
	    		    if(!list.contains(String.valueOf(curarr))) {
	    		    	res.add(String.valueOf(curarr));
	    		    }
	    		    curarr[j] = beifeng[j];
	    		}
	    	}
	    }
		
		return null;
	}

}
