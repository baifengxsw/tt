package cn.itcast08_tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import cn.itcast10_list.ListPaixu.Node;



public class Ceshi {
	
	public static class Node{
		public  int value ;
		public  Node left;
		public Node  right;
		public Node (int value ) {
			this .value = value;
		}
	}
    

	  
	  
	  public   static int solution(int[] prices, int n) {
	        int [] minNumber = new int [ n+1];
	        int [] tempMinJ = new int [ n+1];
	         for(int i = 1 ;i<=n;i++){
	             int j = 0 ;
	             int tempJ = -1;
	             int  temp = Integer.MAX_VALUE;
	             while(j <prices.length && i>= prices[j]){
	                 if(minNumber[i-prices[j]]+1<temp) {
	                	 temp = minNumber[i-prices[j]]+1;
	                	 tempJ = j;
	                 }
	                 j++;
	             }
	             minNumber[i] = temp;
	             tempMinJ[i] = tempJ;
	             
	         
	         }
	         return minNumber[minNumber.length-1];

	     }
	public static void main(String[] args) {
	    int [] prices = new int [] {500,1};
	    System.out.println(solution(prices, 1000));
	}

}
