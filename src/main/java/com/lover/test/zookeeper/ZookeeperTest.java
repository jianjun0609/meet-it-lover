package com.lover.test.zookeeper;

import com.alibaba.fastjson.JSONArray;
import io.swagger.models.auth.In;
import org.apache.zookeeper.*;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author Jack
 * @date 2020/8/13 14:19
 */
public class ZookeeperTest implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    final static String host = "192.168.86.248:2181,192.168.86.249:2181,192.168.86.250:2181";

    public static void main(String[] args) throws Exception{
        test1();
    }

    private static ZooKeeper zk = null;

    private static void test5() throws Exception{
        zk = new ZooKeeper(host, 5000, new ZookeeperTest());
        connectedSemaphore.await();
        String path = "/zk-book";
        String path1 = zk.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("Success create znode:" + path1);
        String path2 = zk.create(path + "/c1", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("Success create znode:" + path2);
        List<String> children = zk.getChildren(path, true);
        System.out.println("------" + JSONArray.toJSONString(children));
        String path3 = zk.create(path + "/c2", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        Thread.sleep(Integer.MAX_VALUE);
    }

    private static void test4() throws Exception{
        ZooKeeper zooKeeper = new ZooKeeper(host, 5000, new ZookeeperTest());
        connectedSemaphore.await();
        zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL, new IStringCallback(), "I am context");
        zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL, new IStringCallback(), "I am context");
        zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL, new IStringCallback(), "I am context");
        Thread.sleep(Integer.MAX_VALUE);
    }

    private static void test3() throws Exception{
        ZooKeeper zooKeeper = new ZooKeeper(host, 5000, new ZookeeperTest());
        connectedSemaphore.await();
        String path1 = zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("Success create znode:" + path1);
        String path2 = zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("Success create znode:" + path2);
    }

    private static void test2() throws Exception{
        ZooKeeper zooKeeper = new ZooKeeper(host, 5000, new ZookeeperTest());
        connectedSemaphore.await();
        long sessionId = zooKeeper.getSessionId();
        byte[] sessionPasswd = zooKeeper.getSessionPasswd();
        // Use illegal sessionId and sessionPassWd
        zooKeeper = new ZooKeeper(host, 5000, new ZookeeperTest(), 1l, "test".getBytes());
        // use correct sessionId and sessionPasswd
        zooKeeper = new ZooKeeper(host, 5000, new ZookeeperTest(), sessionId, sessionPasswd);
        Thread.sleep(Integer.MAX_VALUE);
    }

    private static void test1() throws Exception{
        ZooKeeper zooKeeper = new ZooKeeper(host, 5000, new ZookeeperTest());
        System.out.println("----------------" + zooKeeper.getState());
        try {
            connectedSemaphore.await();
            System.out.println("-----------------");
        }catch (InterruptedException e) {
            System.out.println("-------------Zookeeper session establised.");
        }
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("---------------recevice watched event: " + event);
        if (Event.KeeperState.SyncConnected == event.getState()) {
            if (Event.EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();
            } else if (event.getType() == Event.EventType.NodeChildrenChanged) {
                try {
                    System.out.println("ReGet Child:" + zk.getChildren(event.getPath(), true));
                } catch (Exception e) {

                }
            }
        }
    }

    static class IStringCallback implements AsyncCallback.StringCallback{

        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            System.out.println("create path result:[" + rc + ", " + path + "," + ctx + ", real path name:" + name);
        }
    }
}
