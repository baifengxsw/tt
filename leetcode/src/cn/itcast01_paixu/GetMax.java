package cn.itcast01_paixu;

public class GetMax {
	public static int getMax(int [] arr,int l, int r) {
		if(l == r)
			return arr[l];
		int mid = (r+l)/2;
		int ret1 = getMax(arr,l,mid);
		int ret2 = getMax(arr,mid+1,r);
		return ret1>ret2 ? ret1:ret2;
		
	}
	public static void main(String[] args) {
		int arr [] = {4,18,4,6,9,10};
	    int res = getMax(arr,0,arr.length-1);
	    System.out.println(res+" ");
	}
}
