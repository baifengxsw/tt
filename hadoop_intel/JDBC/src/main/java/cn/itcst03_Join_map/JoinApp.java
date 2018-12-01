package cn.itcst03_Join_map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class JoinApp {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","file:///");  //设置为本地模式
        Job job = Job.getInstance();


        //设置job的各种属性
        job.setJobName("MaxTempApp");//作业名称
        job.setJarByClass(JoinApp.class);//搜索类
        job.setInputFormatClass(TextInputFormat.class);  //设置输入格式

        //添加文件路径 可多条
        FileInputFormat.addInputPath(job,new Path("file:///E:/mr/join/orders.txt"));
        //设置输出路径
        FileOutputFormat.setOutputPath(job,new Path("file:///E:/mr/out/join"));
        job.setMapperClass(MapJoinMapper.class);

        job.setNumReduceTasks(3);  //设置reduce的个数

        //这里就不用设置
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        //等待它
        job.waitForCompletion(true);
    }
}
