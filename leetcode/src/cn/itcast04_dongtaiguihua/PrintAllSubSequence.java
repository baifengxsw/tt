package cn.itcast04_dongtaiguihua;
/**
 * 打印所有子序列  ，并且 是一个选择的过程  ，比如 abc  a有和 无 两种情况 ，b有和无两种情况
 * @author baifeng
 *
 */
public class PrintAllSubSequence {
	public  static void print(char[]arr,int i ,String res) {
		if(i == arr.length) {
			System.out.println(res);
			return ;
		}
		print(arr,i+1,res);
		print(arr,i+1,res+arr[i]);
	}
	public static void main(String[] args) {
		String str = "bac";
		print(str.toCharArray(),0,"");
	}
}
