package cn.itcast11_String;
/**
 * 寻找n是h 的子串 并且返回相应的索引
 * @author baifeng
 *
 */
public class Strstr {
public static int strStr(String h, String n) {
        
		if(h.length()<n.length())
			return -1;
		if(n.length()==0||n.equals("")||h.equals(n))
			return 0;
			int nLen = n.length();
			int len = h.length() -nLen+1;
			for(int i = 0;i<len;i++) {
				String str  = h.substring(i, i+n.length());
				if(str.equals(n))
					return i;
			}
		return -1;
    }

	public static void main(String[] args) {
		String h = "hello";
		String n = "ll";
		int ret = strStr(h, n);
		System.out.println(ret);
	}
}
