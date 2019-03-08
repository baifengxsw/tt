package cn.itcast01_paixu;

public class MaxGap {
	
	/**
	 * ����Ͱ����ĸ��� �����������ı߽�ֵ 
	 * @param arr
	 * @return
	 */
	public static int maxGap(int [] arr) {
		if(arr==null || arr.length<2)
			return 0;
		//���ҵ������Сֵ ���л��� 
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0;i<arr.length;i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		if( min == max)
			return 0;
		int len = arr.length;
		//���з��� 
		boolean hasNum [] = new boolean [len+1];
		int maxs [] = new int [len +1];
		int mins [] = new int [len+1];
		int bid = 0;
		for(int i = 0 ;i<len ;i++) {
			bid = (int)((arr[i]-min)*len/(max-min));
			
			maxs[bid] = hasNum[bid]?Math.max(maxs[bid], arr[i]):arr[i];
			mins[bid] = hasNum[bid]?Math.min(mins[bid], arr[i]):arr[i];
			hasNum[bid] = true;
		}
		
		//������ 
		int res = 0 ;
		int lastMax = 0;
		for ( int j  =1 ; j<=len;j++) {
			if(hasNum[j]) {
				res= Math.max(res,mins[j]-maxs[lastMax]);
				lastMax = j;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int arr[] = {4,5,2,8,13,7};
		int res = maxGap(arr);
		System.out.println("res:"+res);
	}
}
