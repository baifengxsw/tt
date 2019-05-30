package sql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;

import java.util.function.Consumer;

public class SqlDemo1 {
    public static void main(String[] args) throws AnalysisException {
        SparkConf conf = new SparkConf();
        conf.setMaster("local").setAppName("sqlJAVA");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        SparkSession session = SparkSession.builder().appName("javaSql").
                config("spark.master","local[1]").getOrCreate();
       Dataset<Row> dt = session.read().json("file:///e:/s.json");
        dt.createTempView("customer");
        dt.show();
        System.out.println("---------------------------------");
        Dataset<Row> dt1 = dt.where("id >1");
        dt1.show();
        System.out.println("---------------------");

        //按照sql方式进行查询
        Dataset<Row> dt2  = session.sql("select * from customer where id >2 ");

        dt2.show(); //只显示前20
        //转换为java rdd
        JavaRDD<Row> rdd = dt.toJavaRDD();
        //按排序的顺序
        rdd.collect().forEach(new Consumer<Row>() {
            @Override
            public void accept(Row row) {
                long id = row.getLong(0);
                long  age = row.getLong(1);
                String name = row.getString(2);
                System.out.println(id+"----"+age+"----"+name);
            }
        });
        dt1.write().mode(SaveMode.Append).json("file:///e:/out1");
    }
}
