package cn.itcast11_String;
/**
 * ����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1��

����:

s = "leetcode"
���� 0.

s = "loveleetcode",
���� 2.
 

ע����������Լٶ����ַ���ֻ����Сд��ĸ��
 * @author baifeng
 *
 */
public class FirstUniqChar {
	public static int firstUniqChar(String s) {
        char [] arr = new char [26];//һ��26��Сд�ַ�
        char [] sArray = s.toCharArray();
        for(int i = 0;i<s.length();i++) {
        	arr[sArray[i]-'a']++;
        }
        for(int i = 0;i<s.length();i++) {
        	if(arr[sArray[i]-'a']==1)
        		return i;
        }
        return -1;
    }
 public static void main(String[] args) {
	String s = "loveleetcode";
	int ret = firstUniqChar(s);
	System.out.println(ret);
}
}
