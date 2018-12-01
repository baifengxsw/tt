package cn.itcast04_join;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ComboKey  implements WritableComparable<ComboKey>{
    private int cid; //用户名称
    private  int oid; //订单属于的用户编号
    private int type ;//标识是用户还是订单 0 是用户,1是订单
    private  String customerInfo = "";
    private  String orderInfo = "";

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public int compareTo(ComboKey o) {
        //在分区后 所有有着相同的cid都将进入这里
        if(cid == o.cid){
            if(type != o.type){
                //这便是一份订单 ,一个客户
                if(type == 0){
                    return -1;
                }else{
                    return  1;
                }
            }else{
                return cid -o.cid;
            }
        }else{
            return cid - o.cid;
        }
    }

    public void write(DataOutput out) throws IOException {
        out.writeInt(cid);
        out.writeInt(oid);
        out.writeInt(type);
        out.writeUTF(customerInfo);
        out.writeUTF(orderInfo);
    }

    public void readFields(DataInput in) throws IOException {
        cid = in.readInt();
        oid = in.readInt();
        type = in.readInt();
        customerInfo = in.readUTF();
        orderInfo = in.readUTF();
    }
}
