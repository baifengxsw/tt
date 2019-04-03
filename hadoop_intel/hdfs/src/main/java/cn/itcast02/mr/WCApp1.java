package cn.itcast02.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class WCApp1 {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf,args).getRemainingArgs();
        if(otherArgs.length!=2)
        {
            System.out.println("Usage:wordCount<in><out>");
            System.exit(2);
        }
        Job job = Job.getInstance();


        //设置job的各种属性
        job.setJobName("MaxTempApp");//作业名称
        job.setJarByClass(WCApp1.class);//搜索类
        job.setInputFormatClass(TextInputFormat.class);  //设置输入格式

        //添加文件路径 可多条
        FileInputFormat.addInputPath(job,new Path(otherArgs[0]));
        //设置输出路径
        FileOutputFormat.setOutputPath(job,new Path(otherArgs[1]));
        job.setMapperClass(WCMapper.class);
        job.setReducerClass(MCReducer.class);

        job.setNumReduceTasks(4);  //设置reduce的个数
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);//如果map端和reduce端是一致的,可以不进行设置
        //这里就不用设置
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        //等待它
        job.waitForCompletion(true);
    }

}
