package cn.itcast04_dongtaiguihua;

public class JieCheng {
	public static int jiecheng(int n) {
		if(n <1) {
			throw new  RuntimeException("n 不能为负值");
		}
		int sum = 0;
		sum = process(n);
		return sum;
	}

	private static int process(int n) {
		// TODO 自动生成的方法存根
		if(n ==1)
			return 1 ;
		return n*process(n-1);
	}
	public static void main(String[] args) {
		int n = 3;
		int res = jiecheng(n);
		System.out.println("res:"+res);
	}
}
