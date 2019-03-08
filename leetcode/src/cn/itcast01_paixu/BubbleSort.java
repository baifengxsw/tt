package cn.itcast01_paixu;

import java.util.Arrays;

public class BubbleSort {
	public static void bubbleSort(int arr []) {
		if(arr == null || arr.length<2)
			return ;
		for (int i = arr.length-1; i>0;i--) {
			for(int j = 0; j<i ;j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}
	}

	public static void swap(int[] arr, int pos1, int pos2) {
		
		// TODO 自动生成的方法存根
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	
	public static void main(String[] args) {
//		int []  arr = {1,3,7,4,15,8,4};
//		bubbleSort(arr);
//		myPrint(arr);
//		
		int arr [] = generateRandomArray(6, 0, 2);
		myPrint(arr);
	}

	private static void myPrint(int[] arr) {
		System.out.print('[');
		if(arr==null||arr.length==0)
			System.out.println(']');
		for(int i = 0 ;i<arr.length;i++) {
			if(i==arr.length-1) {
				System.out.print(arr[i]+"]");
				
			}else {
				System.out.print(arr[i]+",");
			}
		}
		
	}
	
	/**
	 * 接下来为对数器部分
	 */
	//for系统的正确方法
	public static void rightMethod(int [] arr) {
		Arrays.sort(arr);
		
	}
	//产生随机数组size 限定数组长度范围，value 限定值范围 value1小于value2
	public static int[] generateRandomArray(int size, int value1,int value2) {
		if(value2 <= value1 || size<0)
			return null;
		int arr [] = new int [(int)((size+1)*Math.random())];
		for (int i = 0 ;i<arr.length;i++) {
			arr[i] = (int)((value2-value1+1)*Math.random()+value1);
		}
		return arr;
	}
	
	public static  boolean isEqual(int[] arr1, int [] arr2) {
		if((arr1==null && arr2 !=null) || (arr1!=null && arr2 == null))
			return false ;
		if(arr1 == null && arr2 == null)
			return true;
		if( arr1.length != arr2.length)
			return false;
		for(int i = 0 ; i<arr1.length;i++) {
			if(arr1[i]!=arr2[i])
				return false;
		}
		return true;
	}
}
