package cn.itcast04_dongtaiguihua;

public class Knapsack {
		public static int getMaxValue(int[]w,int []v,int bag) {
			return process(w,v,0,0,bag);
		}
		//cost Ϊ���������� 
		private static int process(int[] w, int[] v, int i, int cost, int bag) {
			//��Ϊcost ��>bag ��ʱ�� ���صĵ�ǰֵ����һ�� ��Ե�����ֵ �����û���� ��ȻӰ�� ���� ����Ϊ cost����bag  ����Я��������ֵ�ض�Ҳ�����  ����Ҫ�к�����������ֵӰ��
			if(cost>bag)
				return Integer.MIN_VALUE;
			//��ֹ�����ں��� 
			if(i==w.length)
				return 0;
			return  Math.max(process(w,v,i+1,cost,bag),v[i]+process(w,v,i+1,cost+w[i],bag));
		}
		
		public static int getMaxValue1(int [] w,int []v,int bag) {
			int dp [][] = new int [w.length+1][bag+1];
			for(int i = w.length-1;i>=0;i--) {
				for(int j = bag;j>=0;j--) {
					if(j+w[i]>bag) {
						dp[i][j]= dp[i+1][j];
					}else {
					dp[i][j]= Math.max(dp[i+1][j], v[i]+dp[i+1][j+w[i]]);
				}
				}	
			}
			return dp[0][0];
		}
		
		
		
		
		
		
		public static void main(String[] args) {
			int[] c = { 3, 2};
			int[] p = { 5, 6};
			int bag = 3;
			int res = getMaxValue(c, p, bag);
			int res1 = getMaxValue1(c,p,bag);
			System.out.println("res:"+res);
			System.out.println("res1:"+res1);
		}
}
