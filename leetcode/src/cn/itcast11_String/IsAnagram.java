package cn.itcast11_String;
/**
 * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ��һ����ĸ��λ�ʡ�

ʾ�� 1:

����: s = "anagram", t = "nagaram"
���: true
ʾ�� 2:

����: s = "rat", t = "car"
���: false
˵��:
����Լ����ַ���ֻ����Сд��ĸ��
 * @author baifeng
 *
 */
public class IsAnagram {
	  public static boolean isAnagram(String s, String t) {
		  	if(s.length()!=t.length())
		  		return false;
	        int[] arr = new int [26] ;//һ��26���ַ�
	        char [] sArr = s.toCharArray();
	        char [] tArr = t.toCharArray();
	        for(int i = 0;i<s.length();i++) {
	        	arr[sArr[i]-'a'] ++;
	        }
	        for(int i = 0;i<t.length();i++) {
	        	if(--(arr[tArr[i]-'a'])<0)
	        		return false;
	        }
	      
	        return true;
	  }
	  public static void main(String[] args) {
		String s = "a";
		String t = "b";
		System.out.println(isAnagram(s, t));
		
	}
}
