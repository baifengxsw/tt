package cn.itcast01.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestA {

    public static void Is(String ip) throws Exception {
        ZooKeeper zk = new ZooKeeper(ip + ":2181", 5000, null);
        List<String> list = zk.getChildren("/", null);
        for (String str : list) {
            System.out.println(str);
        }
    }

    public static void IsAll() throws Exception {
        ZooKeeper zk = new ZooKeeper("192.168.164.132:2181,192.168.164.131:2181",5000,null);
        reCur("/",zk);
    }

    public  static void reCur(String path ,ZooKeeper zk) throws Exception{
        List<String> list = zk.getChildren(path,null);
        if(list.size() == 0){
            return ;
        }
        for(String str:list){
            if(path .equals("/")){
                path = "";
            }
            System.out.println(path +"/"+str);
            reCur(path+"/"+str,zk);
        }
    }

    /**
     * 设置数据 且必须是已经存在的路径
     *
     * @throws Exception
     */
    @Test
    public  void setData() throws Exception{
        ZooKeeper zk = new ZooKeeper("192.168.164.132:2181",5000,null);
        zk.setData("/a/b/c0000000001","xia".getBytes(),0);

    }

    /**
     * 创建临时数据节点
     * 如果创建临时节点的话 ，这个会话结束 会直接消失的
     * @throws Exception
     */
    @Test
    public  void createEmphoral() throws Exception{
        ZooKeeper zk = new ZooKeeper("192.168.164.132:2181",5000,null);
        // 管理
        zk.create("/a/b/f","ddd".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    /**
     * 监听  对一个路径所附带的数据进行观察 ，一旦发现，有人改变它
     *
     *
     * @throws Exception
     */
    @Test
    public  void testWatch() throws  Exception{
        ZooKeeper zk = new ZooKeeper("192.168.164.132:2181",5000,null);
        Stat st = new Stat();
        byte[] data = zk.getData("/a", new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println("数据已经被修改了");
            }
        },st);
        System.out.println(new String (data));
        System.out.println(st.getDataLength());
        while(true){
            Thread.sleep(1000);
        }

    }

    public static void main(String[] args) throws Exception {
   /*     String ip = "192.168.164.132";
        try {
            Is(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
     IsAll();
    }
}
