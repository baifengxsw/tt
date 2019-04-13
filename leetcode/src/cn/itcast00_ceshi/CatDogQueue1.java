package cn.itcast00_ceshi;

import java.util.LinkedList;
import java.util.Queue;
/**
 * pollAll 将队列中的所有的实例按照进队列的先后顺序依次弹出
 * @author baifeng
 *
 */

public class CatDogQueue1 {
	public static class Pet{
		private String type;
		public Pet(String type) {
			this.type = type;
		}
		public String getPetType() {
			return this.type;
		}
	}
	
	public static class Dog extends Pet{
		public Dog() {
			super("dog");
		}
	}
	public static class Cat extends Pet{
		public Cat() {
			super("cat");
		}
	}
	public static class Node {
		private Pet pet;
		private int index;
		
		public Node(Pet pet, int index) {
			super();
			this.pet = pet;
			this.index = index;
		}
		public Pet getPet() {
			return pet;
		}
		public void setPet(Pet pet) {
			this.pet = pet;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
	}
	
	
	public static class DogCatQueue{
	private Queue<Node> catQueue;
	private Queue<Node> dogQueue;
	private int index ;
	
	public DogCatQueue() {
		catQueue = new LinkedList<Node>();
		dogQueue = new LinkedList<Node>();
		index=0;
	}
	public void add(Pet pet) {
		//从1 开始
		
		if(pet.getPetType().equals("cat")) {
			dogQueue.add(new Node(pet,index++));
		}else if(pet.getPetType().equals("dog")) {
			catQueue.add(new Node(pet,index++));
		}else {
			throw new RuntimeException("我怎么知道这是啥玩意");
		}
	}
	public Pet pollAll() {
		if(catQueue.isEmpty()&&dogQueue.isEmpty()) {
			throw new RuntimeException("一个都没有");
		}else if(!catQueue.isEmpty()&&dogQueue.isEmpty()) {
			return catQueue.poll().pet;
		}else if(catQueue.isEmpty()&&!dogQueue.isEmpty()) {
			return dogQueue.poll().pet;
		}else {
			return catQueue.peek().index<dogQueue.peek().index ?catQueue.poll().pet:dogQueue.poll().pet;
		}
	}
	
	public Pet pollDog() {
		if(dogQueue.isEmpty())
			throw new RuntimeException("dog queue is empty");
		return dogQueue.poll().pet;
	}
	
	public Pet pollCat() {
		if(catQueue.isEmpty())
			throw new RuntimeException("cat queue is empty");
		return catQueue.poll().pet;
	}
	
	public boolean isEmpty() {
		return catQueue.isEmpty()&&dogQueue.isEmpty();
	}
	
	public boolean isDogEmpty() {
		return dogQueue.isEmpty();
	}
	
	public boolean isCatEmpty() {
		return catQueue.isEmpty();
		
	}
	}
}
