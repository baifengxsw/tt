package cn.itacast02_isloation;

import cn.itcast01_jdbc.JDBCUtils;
import org.junit.Test;

import javax.xml.ws.RequestWrapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 测试隔离级别
 */
public class TestIsolationLevel {
    /**
     * 执行写,不进行提交
     */
    @Test
    public  void testA(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConn();
            //关闭自动提交
            conn.setAutoCommit(false);
            String sql = "update m_user set password = '1234' where id =2";
            ps = conn.prepareStatement(sql);
            int ret = ps.executeUpdate();
            System.out.println("在等待中-------");

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConn(conn);
            JDBCUtils.closeSt(ps);

        }
    }
    @Test
    public  void testB(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConn();
            //关闭自动提交
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            String sql = "select * from m_user where id =2";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("查询到的数据如下");
                System.out.println(rs.getInt("id")+"  "+rs.getString("username")+"   "+rs.getString("password"));
            }

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConn(conn);
            JDBCUtils.closeSt(ps);
            JDBCUtils.closeRs(rs);
        }
    }
}
