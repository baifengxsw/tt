package cn.itcast04_join;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class JoinDemoMapper extends Mapper<LongWritable,Text,ComboKey,NullWritable>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        FileSplit fs = (FileSplit)context.getInputSplit();
        String path = fs.getPath().toString();
        ComboKey ck = new ComboKey();
        String line = value.toString();
        if(path.contains("customers")){
            int cid = Integer.parseInt(line.substring(0,line.indexOf(" ")));
            String customerInfo = line;
            ck.setCid(cid);
            ck.setCustomerInfo(customerInfo);
            ck.setType(0);
        }else{
            int cid = Integer.parseInt(line.substring(line.lastIndexOf(" ")+1));
            int oid = Integer.parseInt(line.substring(0,line.indexOf(" ")));
            String orderInfo = line.substring(0,line.lastIndexOf(" "));
            ck.setCid(cid);
            ck.setOid(oid);
            ck.setOrderInfo(orderInfo);
            ck.setType(1);
        }
        context.write(ck,NullWritable.get());

    }
}
