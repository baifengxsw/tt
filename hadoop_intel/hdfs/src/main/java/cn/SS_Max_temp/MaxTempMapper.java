package cn.SS_Max_temp;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//前面的两个是输入得k,v ,后面两个是输出的k,v
//k通常是行的偏移量
public class MaxTempMapper extends Mapper<LongWritable,Text,ComboKey,NullWritable>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String [] arr = value.toString().split(" ");
        ComboKey keyOut = new ComboKey();
        keyOut.setYear(Integer.parseInt(arr[0]));
        keyOut.setTemp(Integer.parseInt(arr[1]));
        context.write(keyOut, NullWritable.get());


    }
}
