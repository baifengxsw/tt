package cn.itcast05_mysql_2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
//nullWritable  私有构造方法
public class MCReducer extends Reducer<Text,IntWritable,MyDBWritable,NullWritable>{
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        for (IntWritable iw : values){
            count = count + iw.get();

        }
        MyDBWritable keyout = new MyDBWritable();
        keyout.setWord(key.toString());
        keyout.setCount(count);
        context.write(keyout,NullWritable.get());
    }
}
