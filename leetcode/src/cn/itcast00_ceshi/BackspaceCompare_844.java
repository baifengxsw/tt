package cn.itcast00_ceshi;
/**
 * ���� S �� T �����ַ����������Ƿֱ����뵽�հ׵��ı��༭�����ж϶����Ƿ���ȣ������ؽ���� # �����˸��ַ���

 

ʾ�� 1��

���룺S = "ab#c", T = "ad#c"
�����true
���ͣ�S �� T ������ ��ac����
 * @author baifeng
 *
 */
public class BackspaceCompare_844 {
public static boolean backspaceCompare(String S, String T) {
        char[] sarr = S.toCharArray();
        char[] tarr = T.toCharArray();
        String ss = "";
        String tt = "";
        int count1 = 0;
        for(int i= sarr.length-1 ;i>=0;i--) {
        	if(sarr[i]=='#') {
        		count1++;
        	} else {
        		if(count1==0) {
        		ss = sarr[i] +ss;
        		}else {
        		count1--;
        		}
        	}
        }
        int count2 = 0;
        for(int i= tarr.length-1 ;i>=0;i--) {
        	if(tarr[i]=='#') {
        		count2++;
        	}else {
        		if(count2==0) {
        		tt = tarr[i] +tt;
        		}else {
        		count2--;
        		}
        	}
        }
        
        return tt.compareTo(ss) ==0;

    }
	public static void main(String[] args) {
		String S = "ab#c";
		String T = "ad#c";
		boolean flag = backspaceCompare(S, T);
		
		System.out.println("flag:"+flag);
	}
}
