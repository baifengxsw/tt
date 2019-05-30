package cn.itcast05_mysql_1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//前面的两个是输入得k,v ,后面两个是输出的k,v
//k通常是行的偏移量
public class WCMapper extends Mapper<LongWritable,MyDBWritable,Text,IntWritable>{
    @Override
    protected void map(LongWritable key, MyDBWritable value, Context context) throws IOException, InterruptedException {
        System.out.println(value.getTxt());
        String [] arr = value.getTxt().split(" ");
        for(String s:arr){
            context.write(new Text(s),new IntWritable(1));

        }
    }
}
