package cn.itcast01;

import javafx.scene.control.Tab;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.regionserver.BloomType;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;


/**
 * 用于增删改查
 */
public class TestCRUD {
    public TestCRUD() throws IOException {
    }

    @Test
    public void createBloomFilter()throws Exception{
        Configuration conf = HBaseConfiguration.create();
        Connection conn  = ConnectionFactory.createConnection(conf);
        Admin admin = conn.getAdmin();
        TableName tableName = TableName.valueOf("nn1:t10");
        HTableDescriptor tbl = new HTableDescriptor(tableName);
        HColumnDescriptor col = new HColumnDescriptor("f1");
        col.setBloomFilterType(BloomType.ROW);
        tbl.addFamily(col);
        admin.createTable(tbl);
        System.out.println("over");
    }

    @Test
    public void put() throws IOException {
        //创建conf配置对象
        Configuration conf = HBaseConfiguration.create();
        //通过连接工厂创建连接对象
        conf.set("hbase.zookeeper.quorum", "192.168.2.49:2181,192.168.2.50:2181,192.168.2.60:2181");
        conf.set("zookeeper.znode.parent", "/hbase-unsecure");
        Connection conn = ConnectionFactory.createConnection(conf);
        //创建表名对象
        TableName tName = TableName.valueOf("default:ceshi");
        Table table = conn.getTable(tName);
        //通过bytes工具类创建字节数组(将字符串)
        byte[] rowid = Bytes.toBytes("row9999");
        System.out.println(table.getName());
        //在进行put的时候必须要指定rowid

        Put put = new Put(rowid);
        //添加列的对象
        byte[] f1 = Bytes.toBytes("f1");
        byte[] id = Bytes.toBytes("id");
        byte[] value = Bytes.toBytes(1000);
        put.addColumn(f1, id, value);

        table.put(put);


    }

    @Test
    public void get() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        TableName tName = TableName.valueOf("nn1:t1");
        Table table = conn.getTable(tName);

        byte[] rowId = Bytes.toBytes("row3");
        Get get = new Get(rowId);

        Result res = table.get(get);
        byte[] bys = res.getValue(Bytes.toBytes("fl"), Bytes.toBytes("id"));
        System.out.println(Bytes.toInt(bys));


    }

    @Test
    public void bigPut() throws IOException {
        //创建conf配置对象
        long start = System.currentTimeMillis();
        DecimalFormat format = new DecimalFormat();
        format.applyPattern("0000");
        Configuration conf = HBaseConfiguration.create();
        //通过连接工厂创建连接对象
        Connection conn = ConnectionFactory.createConnection(conf);
        //创建表名对象
        TableName tName = TableName.valueOf("nn1:t1");
        HTable table = (HTable) conn.getTable(tName);
        table.setAutoFlush(false);
        //通过bytes工具类创建字节数组(将字符串)
        for (int i = 1; i < 10000; i++) {
            Put put = new Put(Bytes.toBytes("row" + format.format(i)));
            put.setWriteToWAL(false);
            put.addColumn(Bytes.toBytes("fl"), Bytes.toBytes("id"), Bytes.toBytes(i));
            table.put(put);
            if (i % 1000 == 0) {
                table.flushCommits();
            }
        }
        table.flushCommits();

        long end = System.currentTimeMillis();
        System.out.println(end - start);


    }

    /**
     * 设置缓冲区 防止 出现一个put就 直接提交 ，并且关闭预写日志
     *
     * @throws IOException
     */
    public void bigPut1() throws IOException {
        //创建conf配置对象
        long start = System.currentTimeMillis();
        Configuration conf = HBaseConfiguration.create();
        //通过连接工厂创建连接对象
        Connection conn = ConnectionFactory.createConnection(conf);
        //创建表名对象
        TableName tName = TableName.valueOf("nn1:t1");
        Table table = conn.getTable(tName);
        //通过bytes工具类创建字节数组(将字符串)
        for (int i = 4; i < 1000000; i++) {
            Put put = new Put(Bytes.toBytes("row" + i));
            put.addColumn(Bytes.toBytes("fl"), Bytes.toBytes("id"), Bytes.toBytes(i));
            table.put(put);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);


    }

    @Test
    public void formatNum() {
        DecimalFormat format = new DecimalFormat();
        format.applyPattern("0000000");
        System.out.println(format.format(7));

    }

    @Test
    public void createNamespace() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Admin admin = conn.getAdmin();
        NamespaceDescriptor nd = NamespaceDescriptor.create("nn2").build();
        admin.createNamespace(nd);
    }

    @Test
    public void listNamespace() throws Exception {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Admin admin = conn.getAdmin();
        NamespaceDescriptor[] nds = admin.listNamespaceDescriptors();
        for (NamespaceDescriptor nd : nds) {
            System.out.println(nd.getName());
        }


    }

    @Test
    public void createTable() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);

        Admin admin = conn.getAdmin();
        //至少要指定相应的列
        //创建表名对象
        TableName tName = TableName.valueOf("nn2:t1");
        //创建表描述符对象
        HTableDescriptor hd = new HTableDescriptor(tName);
        HColumnDescriptor col = new HColumnDescriptor("fl");
        //添加列族
        hd.addFamily(col);
        admin.createTable(hd);
        conn.close();

    }

    @Test
    public void dropTable() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Admin admin = conn.getAdmin();
        TableName tName = TableName.valueOf("nn2:t1");
        //如果已经禁用 ，再次禁用会出现错误
        if (!admin.isTableDisabled(tName))
            admin.disableTable(tName);
        admin.deleteTable(tName);

    }

    /**
     * 删除数据
     */
    @Test
    public void deleteData() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        TableName tName = TableName.valueOf("nn2:t1");
        Table table = conn.getTable(tName);
        //对表中数据进行操作先拿到相应的表 ，然后再对其中的数据进行操作
        Delete del = new Delete(Bytes.toBytes("row1"));
        //del.addColumn()
        table.delete(del);


    }

    @Test
    public void scan() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Table table = conn.getTable(TableName.valueOf("nn1:t1"));
        Scan scan = new Scan();
        //扫描最好使用get方法得到相应的区间
        //前开后闭
        scan.setStartRow(Bytes.toBytes("row2"));
        scan.setStopRow(Bytes.toBytes("row3"));
        ResultScanner rs = table.getScanner(scan);
        Iterator<Result> it = rs.iterator();
        //得到的结果是对每个keyvalue的封装
        while (it.hasNext()) {
            Result r = it.next();
            byte[] ret1 = r.getRow();
            byte[] ret = r.getValue(Bytes.toBytes("fl"), Bytes.toBytes("id"));
            System.out.println(Bytes.toString(ret1) + "---" + Bytes.toString(ret));
        }
        conn.close();
    }

    /**
     * 动态遍历一个列族下的所有子列
     */
    @Test
    public void scan2() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Table table = conn.getTable(TableName.valueOf("nn2:t1"));
        Scan scan = new Scan();
        //扫描最好使用get方法得到相应的区间
        //前开后闭
        /*
        scan.setStartRow(Bytes.toBytes("row2"));
        scan.setStopRow(Bytes.toBytes("row3"));
        */

        ResultScanner rs = table.getScanner(scan);
        Iterator<Result> it = rs.iterator();
        //得到的结果是对每个keyvalue的封装
        while (it.hasNext()) {
            Result r = it.next();
            byte[] row = r.getRow();
            Map<byte[], byte[]> map = r.getFamilyMap(Bytes.toBytes("fl"));
            //返回子列的名字和相对应的值
            for (byte[] key : map.keySet()) {
                System.out.println(Bytes.toString(row) + "----" + Bytes.toString(key) + "----" + Bytes.toString(map.get(key)));
            }
        }
        conn.close();
    }

    /**
     * 遍历所有列族下的所有子列  列族 列 时间戳
     */
    @Test
    public void scan3() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Table table = conn.getTable(TableName.valueOf("nn2:t1"));
        Scan scan = new Scan();
        //扫描最好使用get方法得到相应的区间
        //前开后闭
        /*
        scan.setStartRow(Bytes.toBytes("row2"));
        scan.setStopRow(Bytes.toBytes("row3"));
        */

        ResultScanner rs = table.getScanner(scan);
        Iterator<Result> it = rs.iterator();
        //得到的结果是对每个keyvalue的封装
        while (it.hasNext()) {
            Result r = it.next();
            byte[] row = r.getRow();
            //得到一行的所有map key =fl  value =《col ，timestrap ,value>
            NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> map = r.getMap();
            for (byte[] key : map.keySet()) {
                NavigableMap<byte[], NavigableMap<Long, byte[]>> map1 = map.get(key);
                for (byte[] key1 : map1.keySet()) {
                    NavigableMap<Long, byte[]> map2 = map1.get(key1);
                    for (Long key2 : map2.keySet()) {
                        System.out.println(Bytes.toString(row) + "-----" + Bytes.toString(key) + "-------" + Bytes.toString(key1) + "-----------" + key2 +
                                "------" + Bytes.toString(map2.get(key2)));
                    }
                }
            }

        }


    }
    /**
     * 按照版本数得到相应的数据
     */
    @Test
    public  void  getWithVersion() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        TableName tName = TableName.valueOf("nn2:t3");

        Table  table = conn.getTable(tName);
        Get get = new Get(Bytes.toBytes("row1"));
        get.setMaxVersions(2);
        //get.setMaxVersion 不加参数 是当前默认最大版本数
        //get.setTimeRange() 设置时间戳的范围
        get.addColumn(Bytes.toBytes("fl"),Bytes.toBytes("name"));
        //这个只会得到一行数据
        Result rs = table.get(get);

//        Map<byte[],byte[]> map = rs.getFamilyMap(Bytes.toBytes("fl"));
//        for(byte[] key:map.keySet()){
//            System.out.println(Bytes.toString(key)+"----------"+Bytes.toString(map.get(key)));
//        }
        //返回相应列族和列的所有版本
        //必须要拿到相应的列族和子列 这里最好通过相应的列族拿到子列 ，然后 再通过这个拿到所有的不同版本数据
        List<Cell> cells = rs.getColumnCells(Bytes.toBytes("fl"),Bytes.toBytes("name"));
        for(Cell cell:cells){
            String col = Bytes.toString(cell.getQualifier());
            Long time = cell.getTimestamp();
            String value = Bytes.toString(cell.getValue());
            System.out.println(col+"----"+time+"---"+value);
        }




        conn.close();
    }
    /**
     * 保留删除的cell 在有存活时间的基础上
     */
    @Test
    public void createWithTTL() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Admin admin = conn.getAdmin();
        //创建表描述fu
        HTableDescriptor hd = new HTableDescriptor( TableName.valueOf("nn2:t4"));
        HColumnDescriptor hc = new HColumnDescriptor("fl");
        //是否保留要删除的数据
        hc.setKeepDeletedCells(true);
        hc.setTimeToLive(7);
        //添加列族
        hd.addFamily(hc);
        admin.createTable(hd);
        conn.close();
    }
    /**
     * 观察扫描器缓存对查询的优化
     */
    @Test
    public  void  searchScanCache() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        TableName tName = TableName.valueOf("nn1:t1");
        Table table = conn.getTable(tName);
        Scan  scan = new Scan();
        scan.setCaching(1);
        ResultScanner rs = table.getScanner(scan);
        long start = System.currentTimeMillis();
        Iterator<Result>it = rs.iterator();
        while(it.hasNext()){
            Result rt = it.next();
            byte[] value = rt.getValue(Bytes.toBytes("fl"),Bytes.toBytes("id"));
            System.out.println(Bytes.toInt(value));

        }
        long end = System.currentTimeMillis();
        System.out.println("time:"+(end-start)+"ms");

    }
    /**
     * 测试过滤器
     */
    @Test
    public  void testFilter() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Scan scan   = new Scan();
        //创建一个行过滤器
        RowFilter rowFilter = new RowFilter(CompareFilter.CompareOp.LESS_OR_EQUAL,new BinaryComparator(Bytes.toBytes("row2000")));
        scan.setFilter(rowFilter);
        TableName tName = TableName.valueOf("nn1:t1");
        Table table = conn.getTable(tName);
        ResultScanner rs = table.getScanner(scan);
        Iterator<Result> it = rs.iterator();
        while(it.hasNext()){
            Result r = it.next();
            Map<byte[],byte[]> map  = r.getFamilyMap(Bytes.toBytes("fl"));
            for(byte [] key :map.keySet()){
                byte [] value = map.get(key);

                System.out.println(Bytes.toString(key)+"-------------"+Bytes.toInt(value));
            }
        }


           }
    /**
     * 测试列过滤器
     */
    @Test
    public  void testFamilyFilter() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Scan scan   = new Scan();
        //创建一个列过滤器 过滤顺序不是创建顺序 是排序顺序
        FamilyFilter colFilter = new FamilyFilter(CompareFilter.CompareOp.LESS_OR_EQUAL,new BinaryComparator(Bytes.toBytes("fl")));
        scan.setFilter(colFilter);
        TableName tName = TableName.valueOf("nn1:t6");
        Table table = conn.getTable(tName);
        ResultScanner rs = table.getScanner(scan);
        Iterator<Result> it = rs.iterator();
        System.out.println(it.hasNext());
        while (it.hasNext()){
            Result r = it.next();
            byte [] one = r.getValue(Bytes.toBytes("fl"),Bytes.toBytes("id"));
            byte [] two = r.getValue(Bytes.toBytes("f2"),Bytes.toBytes("id"));
            System.out.println(Bytes.toString(one)+Bytes.toString(two));

        }
    }
    /**
     * 测试列过滤器
     */
        @Test
        public  void testQualiFilter() throws IOException {
            Configuration conf = HBaseConfiguration.create();
            Connection conn = ConnectionFactory.createConnection(conf);
            Scan scan   = new Scan();
            //创建一个列过滤器 过滤顺序不是创建顺序 是排序顺序
            QualifierFilter qualiFilter = new QualifierFilter(CompareFilter.CompareOp.LESS,new BinaryComparator(Bytes.toBytes("c2")));
            scan.setFilter(qualiFilter);
            TableName tName = TableName.valueOf("nn1:t6");
            Table table = conn.getTable(tName);
            ResultScanner rs = table.getScanner(scan);
            Iterator<Result> it = rs.iterator();
            System.out.println(it.hasNext());
            while(it.hasNext()){
                Result r = it.next();
                Map <byte[],byte[]> map1 = r.getFamilyMap(Bytes.toBytes("fl"));
                for(byte []key:map1.keySet()){
                    System.out.println("fl"+Bytes.toString(key)+"-----"+Bytes.toString(map1.get(key)));

                }
                Map<byte[],byte[]> map2 = r.getFamilyMap(Bytes.toBytes("f2"));
                for(byte[] key1:map2.keySet()){
                    System.out.println("f2"+Bytes.toString(key1)+"----"+Bytes.toString(map2.get(key1)));
                }
            }

        }
    /**
     * 测试值过滤器
     */
        @Test
        public  void valueFilter() throws IOException {
            Configuration conf = HBaseConfiguration.create();
            Connection conn = ConnectionFactory.createConnection(conf);
            Scan scan   = new Scan();
            //创建一个值过滤器 过滤顺序不是创建顺序 是排序顺序
            ValueFilter valueFilter = new ValueFilter(CompareFilter.CompareOp.NOT_EQUAL,new BinaryComparator(Bytes.toBytes("100")));

            scan.setFilter(valueFilter);
            TableName tName = TableName.valueOf("nn1:t6");
            Table table = conn.getTable(tName);
            ResultScanner rs = table.getScanner(scan);
            Iterator<Result> it = rs.iterator();
            while(it.hasNext()){
                Result r = it.next();
                Map <byte[],byte[]> map1 = r.getFamilyMap(Bytes.toBytes("fl"));
                for(byte []key:map1.keySet()){
                    System.out.println("fl"+Bytes.toString(key)+"-----"+Bytes.toString(map1.get(key)));

                }
                Map<byte[],byte[]> map2 = r.getFamilyMap(Bytes.toBytes("f2"));
                for(byte[] key1:map2.keySet()){
                    System.out.println("f2"+Bytes.toString(key1)+"----"+Bytes.toString(map2.get(key1)));
                }
            }

        }
    /**
     * 测试依赖过滤器  依据依赖的列 的值
     */
    @Test
    public  void testDepFilter() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Scan scan   = new Scan();
        //创建一个依赖过滤器  true  保存依赖项  结果只得到这一列满足条件的值
        DependentColumnFilter dcFilter = new DependentColumnFilter(Bytes.toBytes("f2"),Bytes.toBytes("c2"),false, CompareFilter.CompareOp.EQUAL
        ,new BinaryComparator(Bytes.toBytes("100")));
        scan.setFilter(dcFilter);
        TableName tName = TableName.valueOf("nn1:t6");
        Table table = conn.getTable(tName);
        ResultScanner rs = table.getScanner(scan);
        Iterator<Result> it = rs.iterator();
        System.out.println(it.hasNext());
        while(it.hasNext()){
            Result r = it.next();
            Map <byte[],byte[]> map1 = r.getFamilyMap(Bytes.toBytes("fl"));
            for(byte []key:map1.keySet()){
                System.out.println("fl"+Bytes.toString(key)+"-----"+Bytes.toString(map1.get(key)));

            }
            Map<byte[],byte[]> map2 = r.getFamilyMap(Bytes.toBytes("f2"));
            for(byte[] key1:map2.keySet()){
                System.out.println("f2"+Bytes.toString(key1)+"----"+Bytes.toString(map2.get(key1)));
            }
        }
    }
    /**
     * 测试单例值过滤器 ,(不符合)的整行都被删除
     */
    @Test
    public void  singleColumnFilter() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Scan scan   = new Scan();
        //创建一个单例值过滤器 过滤顺序不是创建顺序 是排序顺序  过滤是最后留下来的 属性
        SingleColumnValueFilter sFilter = new SingleColumnValueFilter(Bytes.toBytes("f2"),Bytes.toBytes("c2"), CompareFilter.CompareOp.NOT_EQUAL,new BinaryComparator(Bytes.toBytes("100")));
        scan.setFilter(sFilter);
        TableName tName = TableName.valueOf("nn1:t6");
        Table table = conn.getTable(tName);
        ResultScanner rs = table.getScanner(scan);
        Iterator<Result> it = rs.iterator();
        while(it.hasNext()){
            Result r = it.next();
            Map <byte[],byte[]> map1 = r.getFamilyMap(Bytes.toBytes("fl"));
            for(byte []key:map1.keySet()){
                System.out.println("fl"+Bytes.toString(key)+"-----"+Bytes.toString(map1.get(key)));

            }
            Map<byte[],byte[]> map2 = r.getFamilyMap(Bytes.toBytes("f2"));
            for(byte[] key1:map2.keySet()){
                System.out.println("f2"+Bytes.toString(key1)+"----"+Bytes.toString(map2.get(key1)));
            }
        }

    }
    /**
     * 测试单例值过滤器 ,(不符合)的整行都被删除  s并且排除所在的单例
     */
    @Test
    public void  singleColumnExFilter() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Scan scan   = new Scan();
        //创建一个单例值过滤器 过滤顺序不是创建顺序 是排序顺序  过滤是最后留下来的 属性
        SingleColumnValueExcludeFilter sFilter = new SingleColumnValueExcludeFilter(Bytes.toBytes("f2"),Bytes.toBytes("c2"), CompareFilter.CompareOp.NOT_EQUAL,new BinaryComparator(Bytes.toBytes("100")));
        scan.setFilter(sFilter);
        TableName tName = TableName.valueOf("nn1:t6");
        Table table = conn.getTable(tName);
        ResultScanner rs = table.getScanner(scan);
        Iterator<Result> it = rs.iterator();
        while(it.hasNext()){
            Result r = it.next();
            Map <byte[],byte[]> map1 = r.getFamilyMap(Bytes.toBytes("fl"));
            for(byte []key:map1.keySet()){
                System.out.println("fl"+Bytes.toString(key)+"-----"+Bytes.toString(map1.get(key)));

            }
            Map<byte[],byte[]> map2 = r.getFamilyMap(Bytes.toBytes("f2"));
            for(byte[] key1:map2.keySet()){
                System.out.println("f2"+Bytes.toString(key1)+"----"+Bytes.toString(map2.get(key1)));
            }
        }

    }
    /**
     * 设置前缀过滤器
     */
    @Test
    public void  prefixFilter() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Scan scan   = new Scan();
        //创建一个基于行的前缀过滤器 过滤顺序不是创建顺序 是排序顺序  过滤是最后留下来的 属性
        PrefixFilter prefixFilter = new PrefixFilter(Bytes.toBytes("xia"));
        scan.setFilter(prefixFilter);
        TableName tName = TableName.valueOf("nn1:t6");
        Table table = conn.getTable(tName);
        ResultScanner rs = table.getScanner(scan);
        Iterator<Result> it = rs.iterator();
        while(it.hasNext()){
            Result r = it.next();
            Map <byte[],byte[]> map1 = r.getFamilyMap(Bytes.toBytes("fl"));
            for(byte []key:map1.keySet()){
                System.out.println("fl"+Bytes.toString(key)+"-----"+Bytes.toString(map1.get(key)));

            }
            Map<byte[],byte[]> map2 = r.getFamilyMap(Bytes.toBytes("f2"));
            for(byte[] key1:map2.keySet()){
                System.out.println("f2"+Bytes.toString(key1)+"----"+Bytes.toString(map2.get(key1)));
            }
        }

    }
    /**
     * 设置分页过滤器 在region 上进行操作 ，有多个region 就有多个操作
     */
    @Test
    public void  pageFilter() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Scan scan   = new Scan();
        //创建一个分页过滤器 过滤顺序不是创建顺序 是排序顺序  过滤是最后留下来的 属性
        PageFilter pageFilter = new PageFilter(10);
        scan.setFilter(pageFilter);
        TableName tName = TableName.valueOf("nn1:t1");
        Table table = conn.getTable(tName);
        ResultScanner rs = table.getScanner(scan);
        Iterator<Result> it = rs.iterator();
        while(it.hasNext()){
            Result r = it.next();
            Map <byte[],byte[]> map1 = r.getFamilyMap(Bytes.toBytes("fl"));
            for(byte []key:map1.keySet()){
                System.out.println("fl"+Bytes.toString(key)+"-----"+Bytes.toInt(map1.get(key)));

            }
            Map<byte[],byte[]> map2 = r.getFamilyMap(Bytes.toBytes("f2"));
            for(byte[] key1:map2.keySet()){
                System.out.println("f2"+Bytes.toString(key1)+"----"+Bytes.toInt(map2.get(key1)));
            }
        }

    }
    /**
     * 只要key 的过滤器  不要value
     */
    @Test
    public void  keyOnlyFilter() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Scan scan   = new Scan();
        //创建一个分页过滤器 过滤顺序不是创建顺序 是排序顺序  过滤是最后留下来的 属性
        KeyOnlyFilter filter = new KeyOnlyFilter();
        scan.setFilter(filter);
        TableName tName = TableName.valueOf("nn1:t1");
        Table table = conn.getTable(tName);
        ResultScanner rs = table.getScanner(scan);
        Iterator<Result> it = rs.iterator();
        System.out.println(it.hasNext());
        while(it.hasNext()){
            Result r = it.next();
            System.out.println(Bytes.toString(r.getRow()));
        }

    }
    /**
     * 查询指定范围的列 limit 是包括的取几个子列 offset 是跳过几个子列
     */
    @Test
    public void  colPageFilter() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Scan scan   = new Scan();
        //创建一个分页过滤器 过滤顺序不是创建顺序 是排序顺序  过滤是最后留下来的 属性
        ColumnPaginationFilter cpFilter = new ColumnPaginationFilter(2,1);

        scan.setFilter(cpFilter);
        TableName tName = TableName.valueOf("nn1:t6");
        Table table = conn.getTable(tName);
        ResultScanner rs = table.getScanner(scan);
        Iterator<Result> it = rs.iterator();
        System.out.println(it.hasNext());
        while(it.hasNext()){
            Result r = it.next();
            byte [] c1 = r.getValue(Bytes.toBytes("f2"),Bytes.toBytes("c1"));
            byte [] c2 = r.getValue(Bytes.toBytes("f2"),Bytes.toBytes("c2"));
            byte [] c3 = r.getValue(Bytes.toBytes("f2"),Bytes.toBytes("c2a"));
            System.out.println(Bytes.toString(c1)+Bytes.toString(c2)+Bytes.toString(c3));

        }

    }
    //regex 正则表达式
    @Test
    public void testLike() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        Scan scan   = new Scan();
        ValueFilter valueFilter = new ValueFilter(CompareFilter.CompareOp.EQUAL,new RegexStringComparator("^1"));

        scan.setFilter(valueFilter);
        TableName tName = TableName.valueOf("nn1:t1");
        Table table = conn.getTable(tName);
        ResultScanner rs = table.getScanner(scan);
        Iterator<Result> it = rs.iterator();
        System.out.println(it.hasNext());
        while(it.hasNext()){
            Result r = it.next();
            byte [] row = r.getRow();
            byte [] value = r.getValue(Bytes.toBytes("fl"),Bytes.toBytes("id"));
            System.out.println(Bytes.toString(row)+"----"+Bytes.toString(value));

        }
    }
    /**
     * 组合查询 select * from t7 where((age<=13) and (name like '%t') or (age>=13)and (name like 't%'))>
     */
        public void testComboFilter() throws IOException {
            Configuration conf = HBaseConfiguration.create();
            Connection conn = ConnectionFactory.createConnection(conf);
            Scan scan   = new Scan();
            //while (age<=13
            SingleColumnValueFilter ftl = new SingleColumnValueFilter(
                    Bytes.toBytes("f2"),
                    Bytes.toBytes("age"),
                    CompareFilter.CompareOp.LESS_OR_EQUAL,
                    new BinaryComparator(Bytes.toBytes(13))
            );

            //where ..f2:name like %t
            SingleColumnValueFilter ftr = new SingleColumnValueFilter(
                    Bytes.toBytes("f2"),
                    Bytes.toBytes("name"),
                    CompareFilter.CompareOp.EQUAL,
                    new RegexStringComparator("t$")
            );
            //调用and
            FilterList ft = new FilterList(FilterList.Operator.MUST_PASS_ALL);
            ft.addFilter(ftl);
            ft.addFilter(ftr);
            //age 大于13
            SingleColumnValueFilter ft2 = new SingleColumnValueFilter(
                    Bytes.toBytes("f2"),
                    Bytes.toBytes("age"),
                    CompareFilter.CompareOp.GREATER,
                    new BinaryComparator(Bytes.toBytes("13 "))
            );

            //where ..f2:name like %t
            SingleColumnValueFilter ftrr = new SingleColumnValueFilter(
                    Bytes.toBytes("f2"),
                    Bytes.toBytes("name"),
                    CompareFilter.CompareOp.EQUAL,
                    new RegexStringComparator("^t")
            );
            //调用and
            FilterList fb = new FilterList(FilterList.Operator.MUST_PASS_ALL);
            fb.addFilter(ft2);
            fb.addFilter(ftrr);
            FilterList fall = new FilterList(FilterList.Operator.MUST_PASS_ONE);
            fall.addFilter(ft);
            fall.addFilter(fb);
            scan.setFilter(fall);


        }
    /**
     * 测试计数器
     */
    @Test
    public  void testIncr() throws  IOException{
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        TableName tName = TableName.valueOf("nn1:t8");
        Table table = conn.getTable(tName);
//        Increment incr = new Increment(Bytes.toBytes("row1"));
//        //进行批量操作
//        incr.addColumn(Bytes.toBytes("fl"),Bytes.toBytes("aid"),10);
//        incr.addColumn(Bytes.toBytes("fl"),Bytes.toBytes("aid"),10);
        table.incrementColumnValue(Bytes.toBytes("row1"),Bytes.toBytes("fl"),Bytes.toBytes("aid"),4);
        conn.close();

    }
}
