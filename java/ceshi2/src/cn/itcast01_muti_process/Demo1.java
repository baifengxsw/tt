package cn.itcast01_muti_process;

import java.util.UUID;

public class Demo1 {
	public static void main(String[] args) {
		String ss = "xia.xml";
		String ret = ss.substring(ss.lastIndexOf("."));
		String ret1 = UUID.randomUUID()+ret;
		System.out.println(ret1);
	}
}
