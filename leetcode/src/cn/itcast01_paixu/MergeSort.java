package cn.itcast01_paixu;

public class MergeSort {
	
	static int summ =0;
	public static void mergeSort(int [] arr) {
		if ( arr== null || arr.length<2)
			return ;
		sortProcess(arr,0,arr.length-1);
	}

	public static void sortProcess(int[] arr, int L, int R) {
			if(L == R)
			return ;
			int mid = L + (R-L)/2;
			sortProcess(arr, L, mid);
			sortProcess(arr,mid+1 ,R);
			merge(arr,L,mid,R);
	}

	public static void merge(int[] arr, int l, int mid, int r) {
		int endArray [] = new int [r - l +1];
		int i = 0; //最终数组的当前位置
		int p1 = l;
		int p2 = mid+1;
		while(p1<=mid && p2<= r) 
			//解决给你一个数组 ，求每个数组左面比它小的值得全部和
		{  
		//summ += arr[p1]<arr[p2] ?(r-p2+1)*arr[p1]: 0;
			
		//求逆序对
			summ += arr[p1]>arr[p2] ?(mid-p1+1): 0;
		endArray[i++] = arr[p1]<arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1<=mid)
			endArray [i++] = arr[p1++];
		while(p2<=r)
			endArray [i++] = arr[p2++];
		
		for (int j = 0 ;j<endArray.length;j++) {
			arr[l+j] = endArray[j];
		}
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
		int []  arr = {4,3,2,1};
	
		mergeSort(arr);
		myPrint(arr);
		System.out.println("summ:"+summ);
	}
		
}
