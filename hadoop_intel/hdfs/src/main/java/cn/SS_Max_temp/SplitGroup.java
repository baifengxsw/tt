package cn.SS_Max_temp;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

//按照年份进行分组
public class SplitGroup extends WritableComparator{
    protected  SplitGroup(){
        super(ComboKey.class,true);

    }

    @Override   //ComboKey 实现了相关的序列化接口
    public int compare(WritableComparable a, WritableComparable b) {
        ComboKey o1 = (ComboKey)a;
        ComboKey o2 = (ComboKey)b;

        //在reduce 中 相同年龄的被分为一个组
        return o1.getYear() - o2.getYear();
    }
}
