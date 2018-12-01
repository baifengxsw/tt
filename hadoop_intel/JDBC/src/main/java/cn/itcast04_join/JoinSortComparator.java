package cn.itcast04_join;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * 这是组合key的排序对比器
 */
public class JoinSortComparator extends WritableComparator {
        protected  JoinSortComparator(){
            super(ComboKey.class,true);

        }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {

            ComboKey k1 = (ComboKey)a;
            ComboKey k2 = (ComboKey)b;
            return k1.compareTo(k2);
        }
}
