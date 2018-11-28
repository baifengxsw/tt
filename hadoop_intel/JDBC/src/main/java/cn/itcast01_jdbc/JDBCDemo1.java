package cn.itcast01_jdbc;

import org.junit.Test;

import java.sql.*;

public class JDBCDemo1 {
    @Test
    public   void testJDBC() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConn();
            String sql = "update m_user set password = ? where id =2";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"1234");
            int ret = ps.executeUpdate();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void testCallableStatement(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConn();
            conn.setAutoCommit(false);
            CallableStatement cst =conn.prepareCall("{call sp_add(?,?,?)}");
            cst.setInt(1,4);
            cst.setInt(2,10);
            //绑定输出参数
            cst.registerOutParameter(3, Types.INTEGER);
            cst.execute();
            //拿到第三个参数返回的值
            int sum = cst.getInt(3);
            conn.commit();
            conn.close();
            System.out.println("sum:"+sum);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public  void testCallableStatementMax(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConn();
            conn.setAutoCommit(false);

            CallableStatement cst =conn.prepareCall("{call sp_batchinsert(?)}");
            cst.setInt(1,1000000);
            cst.execute();
            conn.commit();
            conn.close();
            long end = System.currentTimeMillis();
            System.out.println("共运行了"+(end-start)+"ms");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public  void testCallableStatementFunction(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConn();
            conn.setAutoCommit(false);
            CallableStatement cst =conn.prepareCall("{ ? = call m_add(?,?)}");
            cst.setInt(2,4);
            cst.setInt(3,19);
            //绑定输出参数
            cst.registerOutParameter(1, Types.INTEGER);
            cst.execute();
            //拿到第三个参数返回的值
            int sum = cst.getInt(1);
            conn.commit();
            conn.close();
            System.out.println("sum:"+sum);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
