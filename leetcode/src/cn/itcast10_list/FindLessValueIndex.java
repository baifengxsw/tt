package cn.itcast10_list;

public class FindLessValueIndex {
	public static int findLessValueIndex(int [] arr) {
		if(arr==null||arr.length == 0) {
			return -1;
		}
		if(arr.length==1 || arr[0]<arr[1])
			return 0;
		int N = arr.length ;
		if(arr[N-2]>arr[N-1]) {
			return N-1;
		}
		int low = 1;
		int high = N -2;
		int mid = 0;
		//如果是小于等于的话 ，那么它的最终值必定在mid 上 low mid high这一步下面
		while(low<= high) {
			  mid  = (high+low)/2;
			if(arr[mid]<arr[mid+1]&&arr[mid]<arr[mid-1]) {
				return mid;
			}else if (arr[mid]>arr[mid-1]) {
				high = mid-1;
			}else {
				low = mid +1;
			}
		}
		return mid ;
	}
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 6, 5, 7, 8, 9,7, 8 };
		printArray(arr);
		int index = findLessValueIndex(arr);
		System.out.println("index: " + index + ", value: " + arr[index]);

	}
}
