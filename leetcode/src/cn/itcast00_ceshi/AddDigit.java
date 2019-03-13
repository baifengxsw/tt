package cn.itcast00_ceshi;

public class AddDigit {
	public static int addDigit(int num) {
		int res = process(num);
		while(res>=10) {
			res = process(res);
		}
		return res;
	}
	public static int process(int num) {
		int sum = 0;
		
		while(num > 0) {
			sum +=num %10;
			num = num/10;
		}
		return sum;
	}
    public int addDigits(int num) {
        if(num == 0)
            return 0;
        return (num-1)%9+1;
    }
	public static void main(String[] args) {
		int num = 38;
		int ret = addDigit(num);
		System.out.println("ret:"+ret);
	}
}
