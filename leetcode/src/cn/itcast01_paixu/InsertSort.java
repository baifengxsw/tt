package cn.itcast01_paixu;

public class InsertSort {
	public static void insertionSort(int [] arr) {
		if( arr.length<2 || arr==null)
			return;
		for ( int i =1 ;i<arr.length;i++) {
			//这里需要注意一下
			for(int j = i-1;j >=0&&arr[j]>arr[j+1];j--) {
				swap(arr,j ,j+1);
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
		int []  arr = {1,3,7,4,15,8,4};
		insertionSort(arr);
		myPrint(arr);
	}
	public static void myPrint(int[] arr) {
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
}
