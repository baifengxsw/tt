package cn.cn.itcast05_skew_chain;

import cn.cn.itcast05_skew.RandomPartitioner;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;


import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.chain.ChainMapper;
import org.apache.hadoop.mapreduce.lib.chain.ChainReducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WCApp {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","file:///");  //设置为本地模式
        Job job = Job.getInstance();


        //设置job的各种属性
        job.setJobName("ChainApp");//作业名称
        job.setJarByClass(WCApp.class);//搜索类
        job.setInputFormatClass(TextInputFormat.class);  //设置输入格式

        //添加文件路径 可多条
        FileInputFormat.addInputPath(job,new Path("e:\\mr\\chain"));
        //设置输出路径
        FileOutputFormat.setOutputPath(job,new Path("e:\\mr\\out\\chain"));
        //job.setMapperClass(WCMapMapper1.class); 不需要设置map和reduce 类
        //job.setReducerClass(MCReducer.class);
        ChainMapper.addMapper(job,WCMapMapper1.class,LongWritable.class,Text.class,Text.class,IntWritable.class,conf);
        ChainMapper.addMapper(job,WCMapMapper2.class,Text.class,IntWritable.class,Text.class,IntWritable.class,conf);
        //在reduce端设置reduce
        ChainReducer.setReducer(job,MCReducer.class,Text.class,IntWritable.class,Text.class,IntWritable.class,conf);
        //在相应的reduce上增加map
        ChainReducer.addMapper(job,WCReduceMapper1.class,Text.class,IntWritable.class,Text.class,IntWritable.class,conf);

        job.setNumReduceTasks(4);  //设置reduce的个数

        //等待它
        job.waitForCompletion(true);
    }
}
