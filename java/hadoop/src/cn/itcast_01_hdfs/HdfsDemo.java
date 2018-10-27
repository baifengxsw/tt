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
		// TODO 自动生成的方法存根
		//进行注册url流处理器工厂 （hdfs）
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
	//使用hadoop自带的api函数
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	//put 文件
	//***************如需下载文件请最好先修改 host文件***************************************
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
		fs.delete(p,false);//确定是否递归删除
	}
	public static void main(String[] args) {
//		try {
//			readFileByApi2();
//		} catch (Exception e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		try {
//			mkdir();
//		} catch (Exception e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		try {
//			putFile();
//		} catch (Exception e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		try {
			removeFile();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
