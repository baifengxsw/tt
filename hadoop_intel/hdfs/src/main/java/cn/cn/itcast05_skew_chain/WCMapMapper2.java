package cn.cn.itcast05_skew_chain;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//1号map的输出是2号map的输入
//k通常是行的偏移量
public class WCMapMapper2 extends Mapper<Text,IntWritable,Text,IntWritable>{
    @Override
    protected void map(Text key, IntWritable value, Context context) throws IOException, InterruptedException {
        if(!key.toString().equals("falungong")){
            context.write(key,value);
        }
    }
}
