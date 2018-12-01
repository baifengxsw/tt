package cn.itcast04_join;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;


public class JoinDemoReducer extends Reducer<ComboKey, NullWritable, Text, NullWritable> {
    @Override
    protected void reduce(ComboKey key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        Iterator<NullWritable> it = values.iterator();
        it.next();
        int type = key.getType();
        int cid = key.getCid();
        String cinfo = key.getCustomerInfo();
        while(it.hasNext()){
            it.next();
            int type0 = key.getType();
            int cid0 = key.getCid();
            int oid0 = key.getOid();
            String orderInfo = key.getOrderInfo();
            context.write(new Text(cinfo+" "+orderInfo),NullWritable.get());
        }

    }
}
