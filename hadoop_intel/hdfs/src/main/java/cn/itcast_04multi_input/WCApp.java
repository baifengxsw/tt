package cn.itcast_04multi_input;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WCApp {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","file:///"); //设置为本地模式
        Job job = Job.getInstance();


        //设置job的各种属性
        job.setJobName("MaxTempApp");//作业名称
        job.setJarByClass(WCApp.class);//搜索类
        job.setInputFormatClass(TextInputFormat.class);  //设置输入格式
        //多个输入
        MultipleInputs.addInputPath(job,new Path("e:/cn.itcast05_mysql_1/seq" ),SequenceFileInputFormat.class,WCSeqMapper.class);
        MultipleInputs.addInputPath(job,new Path("e:/cn.itcast05_mysql_1/text"),TextInputFormat.class,WCTextMapper.class);
        //设置输出
        FileOutputFormat.setOutputPath(job,new Path("file:///e:/cn.itcast05_mysql_1/out"));




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
