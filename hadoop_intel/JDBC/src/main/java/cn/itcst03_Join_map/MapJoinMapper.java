package cn.itcst03_Join_map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DFSClient;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * join操作,map端连接
 */
public class MapJoinMapper extends Mapper <LongWritable,Text,Text,NullWritable>{
    private Map<String,String> allCustomers = new HashMap<String,String>();
    /**
     * 在开始任务时调用 将所谓的customers 所有用户都初始化到内存中
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        Configuration conf  = context.getConfiguration();
        FileSystem fs = FileSystem.get(conf );
        FSDataInputStream fis = fs.open(new Path("file:///E:/mr/join/customers.txt"));
        BufferedReader br = new BufferedReader( new InputStreamReader(fis));
        String line  =null;
        while((line = br.readLine())!=null){
            //得到cid
            String cid = line.substring(0,line.indexOf(" "));
            allCustomers.put(cid,line);
        }
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //直接拿到订单的信息
        String line = value.toString();
        //提取customer id
        String cid = line.substring(line.lastIndexOf(" ")+1);
        //在这里不需要-1  因为前包后不包
        String orderInfo = line.substring(0,line.lastIndexOf(" "));

        //在这里连接customer + " " + order
        String customerInfo = allCustomers.get(cid);

        context.write(new Text(customerInfo + " "+orderInfo),NullWritable.get());


    }
}
