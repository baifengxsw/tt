import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.FileOutputStream;
import java.io.IOException;

public class Testsequence {
    //序列化写操作
    public  static  void main(String[] args) throws IOException {
        save();
    }

    public static  void save() throws IOException {
        Configuration con =  new Configuration();
        con.set("fs.defaultFS","file:///");
        FileSystem fs = FileSystem.get(con);
        Path p = new Path("E:/cn.itcast05_mysql_1/seq/1.seq");
        SequenceFile.Writer writer = SequenceFile.createWriter(fs,con,p, IntWritable.class, Text.class);
        for (int i = 0 ;i<100;i++){
            writer.append(new IntWritable(i),new Text("temp"+i));
        }
        writer.close();
    }
}
