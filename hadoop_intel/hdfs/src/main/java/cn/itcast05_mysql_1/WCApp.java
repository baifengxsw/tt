package cn.itcast05_mysql_1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;

import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WCApp {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","file:///");  //设置为本地模式
        Job job = Job.getInstance();


        //设置job的各种属性
        job.setJobName("SQLApp");//作业名称
        job.setJarByClass(WCApp.class);//搜索类
        String URL="jdbc:mysql://localhost:3306/big4";
        String USER= "root";
        String PASS="123321";
        String driverclass="com.mysql.jdbc.Driver";
        DBConfiguration.configureDB(job.getConfiguration(),driverclass,URL,USER,PASS);
        //使用相应的设置初始化map部分
        //设置数据输入的内容
        DBInputFormat.setInput(job,MyDBWritable.class,"select id,name,txt from words","select count(*) from words");
        //添加文件路径 可多条

        //设置输出路径
        FileOutputFormat.setOutputPath(job,new Path("e:\\mr\\out\\sql"));
        job.setMapperClass(WCMapper.class);
        job.setReducerClass(MCReducer.class);

        job.setNumReduceTasks(3);  //设置reduce的个数
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);//如果map端和reduce端是一致的,可以不进行设置
        //这里就不用设置
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        //等待它
        job.waitForCompletion(true);
    }
}
