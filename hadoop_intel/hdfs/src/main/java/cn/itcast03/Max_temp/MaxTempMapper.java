package cn.itcast03.Max_temp;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//前面的两个是输入得k,v ,后面两个是输出的k,v
//k通常是行的偏移量
public class MaxTempMapper extends Mapper<IntWritable,IntWritable,IntWritable,IntWritable>{
    @Override
    protected void map(IntWritable key, IntWritable value, Context context) throws IOException, InterruptedException {

        //String [] arr = value.toString().split(" ");
        //文件格式  年月+温度
       // context.write(new IntWritable(Integer.parseInt(arr[0])),new IntWritable(Integer.parseInt(arr[1])));
        context.write(key,value);
    }
}
