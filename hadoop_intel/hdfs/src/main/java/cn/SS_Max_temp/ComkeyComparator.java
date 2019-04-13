package cn.SS_Max_temp;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class ComkeyComparator extends WritableComparator {
    protected  ComkeyComparator(){
        super(ComboKey.class,true);

    }

    @Override   //ComboKey 实现了相关的序列化接口
    public int compare(WritableComparable a, WritableComparable b) {
        ComboKey o1 = (ComboKey)a;
        ComboKey o2 = (ComboKey)b;
        //默认调类自身的compareto 比较器
        return o1.compareTo(o2);
    }
}