package cn.itcast02_simple_basic;
/**
 * ��ֽ  ��ʹ�ö������ķ�ʽ   ��Ϊ�Ǵ����� �½��д�ӡ  ,��ô���Ӧ�����ϰಿ���������� 
 * @author baifeng
 *
 */
public class PaperFold {
	public class Node {
		public int value ;
		public Node left;
		public Node right;
	}
	public static void paperPrint(int num) {
		if(num <= 0)
			return ;
		printProcess(1,num,true);
	}
	public static void printProcess(int i, int num, boolean b) {
		if(i>num)
			return ;
		printProcess(i+1,num,true);
		System.out.println(b? "��":"��");
		
		printProcess(i+1,num,false);
	}
	public static void main(String[] args) {
		paperPrint(3);
	}
}
