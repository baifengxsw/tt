package cn.itcast02_simple_basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 找到一个单词到另一个单词的最短路径 ，每次只能变化一个字母 ，且 变化的后的单词 必须在相应的列表中 
 * @author baifeng
 *
 */
public class Word_Ladder {

	public static List<List<String>> findLadders(String beginWord,
			String endWord, List<String> wordList) {
		wordList.add(beginWord);
		HashMap<String, List<String>> nexts = getNexts(wordList);
		HashMap<String, Integer> distances = getDistance(nexts, beginWord);
		LinkedList<String> pathList = new LinkedList<>();
		List<List<String>> res = new ArrayList<>();
		getShortestPath(beginWord, endWord, nexts, distances, pathList, res);
		return res;
	}
	public static List<String> getNext(String word,HashSet<String> set){
		List<String> list = new ArrayList<>();
		char [] chs = word.toCharArray();
		for(char i = 'a';i<'z';i++) {
			for(int j = 0;j<chs.length;j++) {
				if(chs[j]!=i) {
				char temp = chs[j];
				chs[j] = i;
				String res = String.valueOf(chs);
				if(set.contains(res)) {
					list.add(res);
				}
				chs[j] = temp;
				}
				
			}
		}

		return list ;
	}
	
	public static HashMap<String,List<String>> getNexts(List<String>list){
		HashSet<String> dict = new HashSet<>(list);
		HashMap<String,List<String>> retMap = new HashMap<>();
		for(String str :list) {
			retMap.put(str, getNext(str,dict));
		}
		return retMap;
	}
	/**
	 * 宽度优先遍历
	 * @param map
	 * @param begin
	 * @return
	 */
	public static HashMap<String,Integer> getDistance(HashMap<String,List<String>>map,String begin) {
		HashMap<String,Integer> retMap = new HashMap<>(); 
		retMap.put(begin, 0);
		Queue<String> queue = new LinkedList<>();
		queue.add(begin);
		//确保不回头遍历  set
		HashSet<String> set = new HashSet<>();
		set.add(begin);
		while(!queue.isEmpty()) {
			String cur = queue.poll();
			for(String str:map.get(cur)) {
				if(!set.contains(str)) {
					queue.add(str);
					set.add(str);
					retMap.put(str,retMap.get(cur)+1);
				}
			}
		}
		return retMap;
	}
	/**
	 * 深度搜索
	 * @param cur
	 * @param end
	 * @param nexts
	 * @param distances
	 * @param solution
	 * @param res
	 */
	public static void getShortestPath(String cur,String end,HashMap<String,List<String>>nexts,HashMap<String,Integer> distances,LinkedList
			<String>solution,List<List<String>> res) {
		solution.add(cur);
		if(end.equals(cur)) {
			res.add(new LinkedList<String>(solution));
		}else {
			for(String next:nexts.get(cur)) {
				if(distances.get(next) == distances.get(cur)+1) {
					getShortestPath(next, end, nexts, distances, solution, res);
				}
			}
		}
		solution.pollLast();
		
	}
	
	
	
}
