package cn.SS_Max_temp;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PrepareDemo {
    public static void main(String[] args) {
        try {
            makeData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void makeData() throws  Exception{
        FileWriter fw = new FileWriter("e:/cn.itcast05_mysql_1/MaxTemp/temp.txt");
        for(int i = 0 ; i<10000;i++){
            int year = 1970 + new Random().nextInt(100);
            int temp = -30 + new Random().nextInt(100);
            fw.write(""+year+" "+temp+"\r\n");
        }
        fw.close();
    }
    public static  void makeData2() throws IOException {
        Configuration con =  new Configuration();
        con.set("fs.defaultFS","file:///");
        FileSystem fs = FileSystem.get(con);
        Path p = new Path("E:/cn.itcast05_mysql_1/MaxTemp/temp.seq");
        SequenceFile.Writer writer = SequenceFile.createWriter(fs,con,p, IntWritable.class, IntWritable.class);
        for (int i = 0 ;i<1000;i++){
            writer.append(new IntWritable(new Random().nextInt(100)+1970),new IntWritable(-30 + new Random().nextInt(100)));
        }
        writer.close();
    }
}
