package cn.itcast00_ceshi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import cn.itcast10_list.ListNode;
import cn.itcast10_list.IsPalindromeList.Node;
/**
 * 实现链表的就地逆置
 * @author baifeng
 *
 */
public class Ceshi {
		public static String[] getSplits(String str) {
			if(str==null || str.length()==0)
				return null;
			String [] arr = str.split("\\s+");
			
			if(arr.length ==2) {
				return new String [] {arr[0] +" "+arr[1]};
			}else if(arr.length >2) {
				String [] ret = new String [2*(arr.length-2)+1];
				int index = 0;
				for(int i = 0;i<arr.length-1;i++) {
					for(int j = 1;j<3;j++) {
						ret[index++] = arr[i]+" "+arr[i+j];
						if(i == arr.length-2)
							break;
					}
				}
				return ret;
			}else {
			
			return null;
			}
		}
	
		public static void main(String[] args) {
			String str = "hello world1 world2";
			String [] strs = getSplits(str);
			for(String str1:strs) {
				System.out.println(str1);
			}
		}
}
