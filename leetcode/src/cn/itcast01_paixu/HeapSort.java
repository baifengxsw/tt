package cn.itcast01_paixu;
/**
 * 实现堆排序
 * @author baifeng
 *
 *建立大根堆 
 */
public class HeapSort {
	public static void heapSort(int [] arr) {
		if(arr==null || arr.length<2)
			return;
		for(int i = 0 ;i<arr.length;i++) {
			heapInsert(arr,i);
		}
		//size 限定堆在数组的范围  
		int size = arr.length;
		swap(arr, 0 ,--size);
		while(size>0) {
			//向下进行调整
			heapify(arr,0,size);
			swap(arr,0,--size);
			
		}
	}
	public static void heapify(int[] arr, int index, int size) {
		int left = 2*index +1;
		while(left <size) {
			int lagest = left+1<size&&arr[left]<arr[left+1]? left+1:left;
			lagest = arr[lagest]<arr[index]?index:lagest;
			if(index == lagest)
				break;
			swap(arr,lagest,index);
			index=lagest;
			left= index*2+1;
		}
		
	}
	/**
	 * 向下建堆的过程 向上校验 
	 * @param arr
	 * @param i
	 */
	public static void heapInsert(int[] arr, int i) {
		while(arr[i]>arr[(i-1)/2]) {
			swap(arr,i ,(i-1)/2);
			i = (i-1)/2;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
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
		int arr [] = { 13,4,45,78,17,2};
		heapSort(arr);
		myPrint(arr);
	}
}
