package cn.cn.itcast05_skew_chain;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//前面的两个是输入得k,v ,后面两个是输出的k,v
//k通常是行的偏移量
public class WCReduceMapper1 extends Mapper<Text,IntWritable,Text,IntWritable> {
    @Override
    protected void map(Text key, IntWritable value, Context context) throws IOException, InterruptedException {
        //对单词频率数大于5的进行输出
        if (value.get() >=5) {
            context.write(key, value);
        }
    }
}
