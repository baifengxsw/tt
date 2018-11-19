package cn.cn.itcast05_skew;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//前面的两个是输入得k,v ,后面两个是输出的k,v
//k通常是行的偏移量
public class WCMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
       Text keyout = new Text();
       IntWritable valueout = new IntWritable();
        String [] arr = value.toString().split(" ");
       for (String s : arr){
           keyout.set(s);
           valueout.set(1);
           context.write(keyout,valueout);
       }
    }
}
