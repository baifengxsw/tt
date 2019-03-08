package cn.itcast04_dongtaiguihua;

public class PrintAllPermutation {
	public static void print(char [] arr,int i) {
		if(i == arr.length) {
			System.out.println(String.valueOf(arr));
			return ;
		}
		for(int j = i; j<arr.length;j++) {
			swap(arr,i,j);
			print(arr,i+1);
			swap(arr,j,i);
		}
	}

	private static void swap(char[] arr, int i, int j) {
		// TODO 自动生成的方法存根
		char temp = arr [i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		String str = "abc";
		print(str.toCharArray(),0);
	}
}
