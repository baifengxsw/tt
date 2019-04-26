package jVm;

import java.text.DecimalFormat;

/**
 * ����Ӧ����������
 * @author baifeng
 *
 */
public class Ceshi1 {
	  public static void main(String[] args) throws InterruptedException {
	         byte[] b1 = new byte[1 *1024 * 1024];
	         System.out.println("������1m");
	         jvmInfo();           
	         Thread.sleep(3000);
	         byte[] b2 = new byte[4 * 1024 * 1024];
	         System.out.println("������4m");
	         Thread.sleep(3000);
	         jvmInfo();

	     }
	     static private String toM(long maxMemory) {
	         float num = (float) maxMemory / (1024 * 1024);
	         DecimalFormat df = new DecimalFormat("0.00");// ��ʽ��С��
	         String s = df.format(num);// ���ص���String����
	         return s;
	     }
	     static private void
	  jvmInfo() {
	         // ����ڴ�
	    	
	         long maxMemory = Runtime.getRuntime().maxMemory();
	         System.out.println("maxMemory:" + maxMemory + ",ת��ΪM:" + toM(maxMemory));
	         // ��ǰ�����ڴ�
	         long freeMemory = Runtime.getRuntime().freeMemory();
	         System.out.println("freeMemory:" +freeMemory+",ת��ΪM:"+toM(freeMemory));
	         // �Ѿ�ʹ���ڴ�
	         long totalMemory = Runtime.getRuntime().totalMemory();
	         System.out.println("totalMemory:" +totalMemory+",ת��ΪM"+toM(totalMemory));
	     }
	}


