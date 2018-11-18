package cn.itcast02.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.FileOutputStream;
import java.io.IOException;

public class WCApp {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
//        conf.set("fs.defaultFS","file:///");  //设置为本地模式
        Job job = Job.getInstance();


        //设置job的各种属性
        job.setJobName("MaxTempApp");//作业名称
        job.setJarByClass(WCApp.class);//搜索类
        job.setInputFormatClass(TextInputFormat.class);  //设置输入格式

        //添加文件路径 可多条
        FileInputFormat.addInputPath(job,new Path(args[0]));
        //设置输出路径
        FileOutputFormat.setOutputPath(job,new Path(args[1]));
        job.setMapperClass(WCMapper.class);
        job.setReducerClass(MCReducer.class);
        job.setNumReduceTasks(1);  //设置reduce的个数
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);//如果map端和reduce端是一致的,可以不进行设置
        //这里就不用设置
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        //等待它
        job.waitForCompletion(true);
    }
}
