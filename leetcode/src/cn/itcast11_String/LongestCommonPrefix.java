package cn.itcast11_String;
/**
 * ��дһ�������������ַ��������е������ǰ׺��

��������ڹ���ǰ׺�����ؿ��ַ��� ""��

ʾ�� 1:

����: ["flower","flow","flight"]
���: "fl"
ʾ�� 2:

����: ["dog","racecar","car"]
���: ""
����: ���벻���ڹ���ǰ׺��
˵��:

��������ֻ����Сд��ĸ a-z ��
 * @author baifeng
 *
 */
public class LongestCommonPrefix {
	 public static String longestCommonPrefix1(String[] strs) {
		 if(strs==null||strs.length==0)
			 return "";
		 if(strs.length==1) {
			 return strs[0];
		 }
		 String res = "";
		 for(int i = 0;i<strs[0].length();i++) {
			 char ch = strs[0].charAt(i);
			 for(int j = 1;j<strs.length;j++) {
				 if(i>=strs[j].length()||strs[j].charAt(i)!=ch)
					 return res;
			 }
			 res += String.valueOf(ch);
		 }
		 return res;
	 }
	 /**
	  * ���ǿ��Զ�����ķ��������ʵ�����������Ƿ��ֵ�ǰĳ���ַ���
	  * ��һ���ַ�����Ӧλ�õ��ַ�����ȣ�˵���������и����Ĺ�ͬǰ׺�ˣ�����ֱ��ͨ����substr�ķ���ֱ��ȡ����ͬǰ׺�����ַ����������������ǰû�з��ؽ���Ļ���˵����һ�����ʾ��ǹ���ǰ׺������Ϊ������ɡ���������
	  * @param strs
	  * @return
	  */
	 public static String longestCommonPrefix(String[] strs) {
		 if(strs==null||strs.length==0)
			 return "";
		 if(strs.length==1) {
			 return strs[0];
		 }
		 for(int i = 0;i<strs[0].length();i++) {
			 char ch = strs[0].charAt(i);
			 for(int j = 1;j<strs.length;j++) {
				 if(i>=strs[j].length()||strs[j].charAt(i)!=ch)
					 return strs[j].substring(0, i);
			 }
		 }
		 return strs[0];
	 }
	 
	 
	 public static void main(String[] args) {
		String [] strs = {"c","c"};
		String ret = longestCommonPrefix(strs);
		System.out.println(ret);
	}
}
