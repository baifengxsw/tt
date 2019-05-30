package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ThriftServerClient {
    public static void main(String[] args) throws Exception {

        Class.forName("org.apache.hive.jdbc.HiveDriver");
        Connection conn = DriverManager.getConnection("jdbc:hive2://master:10000/");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tt where id >1 order by age desc");
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            System.out.println("id:"+id +"name:"+name+"age:"+age);
        }
    }
}
