package cn.itcast05_mysql_2;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDBWritable implements Writable,DBWritable{
    //前两个实现自身的序列化接口
    private  String name ="" ;
    private  String txt = "" ;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private  String word = "";
    private  int count =0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private  int id = 0;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
    //id 自动增长,暂时就不需要

    public void write(DataOutput out) throws IOException {
        out.writeInt(id);
        out.writeUTF(name);
        out.writeUTF(txt);
        out.writeUTF(word);
        out.writeInt(count);

    }

    public void readFields(DataInput in) throws IOException {
        id = in.readInt();
        name = in .readUTF();
        txt = in.readUTF();
        word = in.readUTF();
        count = in.readInt();
    }
    //后面两个事项数据库的读写接口

    /**
     * 这个是针对写的过程
     * @param ps
     * @throws SQLException
     */
    public void write(PreparedStatement ps) throws SQLException {
           ps.setString(1,word);
           ps.setInt(2,count);
    }

    /**
     * 这是针对读的过程
     * @param rs
     * @throws SQLException
     */
    public void readFields(ResultSet rs) throws SQLException {
            id =rs.getInt("id");
            name = rs.getString("name");
            txt =rs.getString("txt");
    }
}
