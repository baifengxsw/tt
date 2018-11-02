import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;

public class Test02 {


    public static void main(String[] args) {
//        try {
//            readFile();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            mkdir();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            removeFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 文件
     * @throws Exception
     */
    public  static  void readFile() throws Exception{
        //调用配置
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://192.168.164.131:9000");
        FileSystem fs = FileSystem.get(conf);  //有点像单例模式 一共仅有一份配置
        Path path = new Path("/usr/hadoop/readme_eclipse.html");
        FSDataInputStream fis =  fs.open(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        /*byte [] bys = new byte[1024]; //作为缓冲区
        int len = -1;
        while((len=fis.read(bys))!=-1){
            baos.write(bys,0,len);

        }*/
        IOUtils.copyBytes(fis,baos,1024);
        fis.close();
        baos.close();
        System.out.println(new String(baos.toByteArray()));

    }

    /**
     * 创建目录
     * @throws Exception
     */
    public  static  void mkdir() throws  Exception{
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://192.168.164.131:9000");
        FileSystem fs = FileSystem.get(conf);
        fs.mkdirs(new Path("/usr/hadoop/mkdir2"));

    }

    /**
     * 上传文件
     * @throws Exception
     */
    public  static  void putFile() throws  Exception{
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://192.168.164.131:9000");
        FileSystem fs = FileSystem.get(conf);
        FSDataOutputStream fos = fs.create(new Path("/usr/baifeng/core-site.xml"));
//        fos.write("How are you".getBytes());
        //读取本地文件并读取
        BufferedInputStream f = new BufferedInputStream(new FileInputStream("D:\\tt\\hadoop_intel" +
                "\\hdfs\\src\\main\\resources\\core-site.xml"));
        byte [] bys = new byte[1024];
        int len = -1;
        while((len=f.read(bys))!=-1){
            fos.write(bys,0,len);
        }
        fos.close();
        fs.close();


    }

    /**
     * 删除路径 ,可选递归删除
     * @throws Exception
     */
    public  static  void removeFile() throws Exception{
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://192.168.164.131:9000");
        FileSystem fs =  FileSystem.get(conf);
        fs.delete(new Path("/usr/baifeng/core-site.xml"),false);

    }
    /**
     * 定制副本数和blocksize
     *
     */
    public static  void  putFile2() throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://192.168.164.131:9000");
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
