package cn.itcast01_paixu;

public class SelectionSort {
	public static void selectionSort(int [] arr) {
		if(arr ==null || arr.length <2)
		return ;
		for(int i = 0 ;i<arr.length-1;i++) {
			int min = i;
			for(int j = i+1 ;j <arr.length ;j++) {
				min = arr[i]<arr [j]? min :j;
			}
			if(min !=i)
				swap(arr, i ,min);
		}
	}
	public static void swap(int[] arr, int pos1, int pos2) {
			
			// TODO 自动生成的方法存根
			int temp = arr[pos1];
			arr[pos1] = arr[pos2];
			arr[pos2] = temp;
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
	public static void main(String[] args) {
		int []  arr = {1,3,7,4,15,8,4};
		selectionSort(arr);
		myPrint(arr);
	}
}
