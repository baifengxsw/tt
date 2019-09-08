package cn.itcast01_paixu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;

import com.sun.javafx.collections.MappingChange.Map;

import cn.itcast10_list.IsPalindromeList.Node;


/** 
 * 最小的分钱方法
 * @param data
 */
public class Ceshi {
   public static class Thread1 implements Runnable{
	 
	  @Override
		public void run() {
		  try {
		   for(int i = 0 ;i<10;i++) {
			  System.out.println(i);
			  Thread.sleep(1000);
		   }
		  }catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + "有程序中断当前线程");
		}
		}
   }
   
  
   
   public static void main(String[] args) {
     ExecutorService pool = Executors.newFixedThreadPool(1);
	 pool.execute(new Thread1());
	 pool.execute(new Thread1());
	 System.out.println("over");
     System.out.println(24&16);
}
}
