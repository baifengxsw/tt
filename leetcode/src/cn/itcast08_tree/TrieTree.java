package cn.itcast08_tree;

import java.util.HashMap;

public class TrieTree {
	public static class Node {
		int pass;
		int end ;
		HashMap<Character,Node> nextMap;
		public Node(){
			pass = 0;
			end = 0;
			nextMap = new HashMap<>();
		}
	}
	public static class Trie{
		private Node root ;
		
		public Trie(){
			root = new Node();
		}
		
		public void insert(String word) {
			if(word == null)
				return ;
			char [] wordArray = word.toCharArray();
			Node cur = root;
			for(int i = 0 ;i <wordArray.length;i++) {
				if(!cur.nextMap.containsKey(wordArray[i])) {
					Node newNode = new Node();
					cur.nextMap.put(wordArray[i], newNode);
				}
					cur = cur.nextMap.get(wordArray[i]);
					cur.pass++;
			}
			cur.end++;
		}
		//表示word 在数组中出现几次
		public int  search(String word) {
			if(word == null)
				return 0 ;
			Node cur = root;
			char [] wordArray = word.toCharArray();
			for(int i = 0; i<wordArray.length;i++) {
				if(!cur.nextMap.containsKey(wordArray[i])) {
					return 0;
				}
				cur = cur.nextMap.get(wordArray[i]);
			}
			return cur.end;
		}
		
		//表示在数组中删除某个字符 
		public void delete(String word) {
			if(search(word)==0)
				return ;
			char [] wordArray =  word.toCharArray();
			Node cur = root ;
			for(int i = 0; i<wordArray.length;i++) {
				if(--cur.nextMap.get(wordArray[i]).pass == 0) {
					cur.nextMap.remove(wordArray[i]);
					return ;
				}
				cur = cur.nextMap.get(wordArray[i]);
			}
			//这是如果出现多次的样子
			cur.end--;
		}
		
		public int prefixNum (String word) {
			if(word == null)
				return 0;
			char [] chs = word.toCharArray();
			Node cur = root;
			for(int i = 0;i<chs.length;i++) {
				if(!cur.nextMap.containsKey(chs[i])) {
					return 0;
				}
				cur = cur.nextMap.get(chs[i]);
			}
			return cur.pass;
		}
		
	}
	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		
		System.out.println(trie.search("zuo"));
		System.out.println("-----------------------------------------");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNum("zuo"));

	}
}
