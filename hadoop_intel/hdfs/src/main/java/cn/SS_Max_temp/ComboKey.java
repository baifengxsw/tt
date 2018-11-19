package cn.SS_Max_temp;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

//继承hadoop串行化机制  java串行化效率低 ,并且较为复杂 不能跨语言
public class ComboKey implements WritableComparable<ComboKey >{
    private  int year;
    private  int temp;

    public int getYear() {
        return year;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * 年份升序排序,气温降序排列
     * @param o
     * @return
     */
    public int compareTo(ComboKey o) { //进行比较通过自身的值优先
        int y = o.getYear();
        int t = o.getTemp();
        int num = year - y;
        int ret1 = num == 0 ? t-temp:num;
        return ret1;
    }

    /**
     * 串行
     * @param out
     * @throws IOException
     */
    public void write(DataOutput out) throws IOException {
        //年份
        out.writeInt(year);
        //气温
        out.writeInt(temp);
    }

    /**
     * 反串行
     * @param in
     * @throws IOException
     */
    public void readFields(DataInput in) throws IOException {
        year = in.readInt();
        temp = in.readInt();
    }
}
