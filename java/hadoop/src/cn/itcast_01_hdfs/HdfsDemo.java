package cn.itcast_01_hdfs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class HdfsDemo {
	public static void readFile() throws Exception {
		// TODO �Զ����ɵķ������
		//����ע��url������������ ��hdfs��
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
		URL url = new URL("hdfs://192.168.164.131:9000/usr/hadoop/readme_eclipse.html");
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
		byte[] buf = new byte[is.available()];
		is.read(buf);
		is.close();
		String str = new String(buf);
		System.out.println(str);
	}
	public static void readFileByApi() throws Exception {
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.164.131:9000");
		FileSystem fs = FileSystem.get(conf);
		Path p = new Path("/usr/hadoop/readme_eclipse.html");
		FSDataInputStream fis= fs.open(p);
		byte [] buf = new byte[1024];
		int len =-1;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while((len=fis.read(buf)) !=-1){
			baos.write(buf,0,len);
		}
		fis.close();
		baos.close();
		System.out.println(new String(baos.toByteArray()));
		
	}
	//ʹ��hadoop�Դ���api����
	public static void readFileByApi2() throws Exception {
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.164.131:9000");
		FileSystem fs = FileSystem.get(conf);
		Path p = new Path("/usr/hadoop/readme_eclipse.html");
		FSDataInputStream fis= fs.open(p);
		byte [] buf = new byte[1024];
		int len =-1;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		IOUtils.copyBytes(fis, baos, 1024);
		fis.close();
		baos.close();
		System.out.println(new String(baos.toByteArray()));
		
	}
	public static void mkdir() throws Exception {
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.164.131:9000");
		FileSystem fs = FileSystem.get(conf);
		try {
			fs.mkdirs(new Path("/usr/mkdir1"));
		} catch (IllegalArgumentException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	//put �ļ�
	//***************���������ļ���������޸� host�ļ�***************************************
	public static void  putFile() throws Exception {
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.164.131:9000");
		FileSystem fs = FileSystem.get(conf);
		FSDataOutputStream out = fs.create(new Path("/usr/mkdir1/a.txt"));
		out.write("hello world".getBytes());
		out.close();
	}
	public static void removeFile() throws Exception {
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.164.131:9000");
		FileSystem fs = FileSystem.get(conf);
		Path p = new Path("/usr/mkdir1/a.txt");
		fs.delete(p,false);//ȷ���Ƿ�ݹ�ɾ��
	}
	public static void main(String[] args) {
//		try {
//			readFileByApi2();
//		} catch (Exception e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}
//		try {
//			mkdir();
//		} catch (Exception e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}
//		try {
//			putFile();
//		} catch (Exception e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}
		try {
			removeFile();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
