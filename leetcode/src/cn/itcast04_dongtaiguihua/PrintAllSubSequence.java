package cn.itcast04_dongtaiguihua;
/**
 * ��ӡ����������  ������ ��һ��ѡ��Ĺ���  ������ abc  a�к� �� ������� ��b�к����������
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
