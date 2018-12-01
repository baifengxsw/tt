package cn.itcast04_join;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class JoinGroupComparator extends WritableComparator{
    protected  JoinGroupComparator(){
        super(ComboKey.class,true);

    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {

        ComboKey k1 = (ComboKey)a;
        ComboKey k2 = (ComboKey)b;
        return k1.getCid() - k2.getCid();
    }
}
