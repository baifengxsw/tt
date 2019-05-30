package cn.itcast01.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;

import static java.nio.channels.FileChannel.open;

public class Test01 {
    public static void main(String[] args) throws IOException {
//        readFile();
        putFile2();
    }
    public static  void readFile() throws IOException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path("hdfs://192.168.164.131:9000/usr/hadoop/readme_eclipse.html");
        FSDataInputStream fis = fs.open(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        IOUtils.copyBytes(fis, baos, 1024);//只要是输入输出流都可以使用
        fis.close();
        System.out.println(new String(baos.toByteArray()));

    }

    /**
     * 写入文件 需要在当前目录下添加core-site.xml
     * @throws IOException
     */
    public  static  void putFile() throws IOException{
        Configuration conf = new Configuration();
        FileSystem fis = FileSystem.get(conf);
//        Path path = new Path("hdfs://192.168.164.131:9000/usr/baifeng/ss.txt" );
        FSDataOutputStream fos = fis.create(new Path("/usr/baifeng/ss.txt"));
        fos.write("hao are you".getBytes());
        fos.close();
        fis.close();
        }
    /**
     * 定制副本数和blocksize
     *
     */
    public static  void  putFile2() throws IOException {
        Configuration conf = new Configuration();
        FileSystem fis = FileSystem.get(conf);
//        Path path = new Path("hdfs://192.168.164.131:9000/usr/baifeng");
        FSDataOutputStream fos = fis.create(new Path("/usr/baifeng/h.html"),true,1024,
                (short)3,1024*1024);
        FileInputStream f = new FileInputStream("D:\\tt\\hadoop_intel\\hdfs\\src\\main\\resources\\core-site.xml");
        byte [] bys = new byte[1024];
        int len = -1;
        while((len=f.read(bys))!=-1){
            fos.write(bys,0,len);
        }

        fos.close();
        f.close();
    }

}

