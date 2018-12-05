package cn.itcast01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 使用jdbc连接hive ,并且 hive必须开启server2
 */
public class App {
    public static void main(String[] args) throws  Exception{
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.164.131:10000/ceshi","hadoop","123321");
        Statement st = conn.createStatement();
        st.executeUpdate("insert into tt values(24,'123')");
        System.out.println(conn.isClosed());
    }
}
