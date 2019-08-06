package sql;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * hive 的测试
 */
public class SqlHivejdbcDemo {
    public static void main(String[] args) {
        //必须要conf
        SparkConf conf = new SparkConf();
        conf.setMaster("local");
        conf.setAppName("hivedemo");
        SparkSession session = SparkSession.builder().appName("jdbcSql").
                config("spark.master","local").getOrCreate();
        System.out.println(session);




        //Dataset<Row> df = session.sql("select * from ceshi.tt1");
        //df.show();
        session.close();
    }
}
