package com.lover.test.zookeeper;

import lombok.Data;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.framework.recipes.barriers.DistributedBarrier;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author Jack
 * @date 2020/8/13 17:43
 */
public class ZkCuratorTest {

    final static String host = "192.168.86.248:2181,192.168.86.249:2181,192.168.86.250:2181";

    private static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString(host)
            .sessionTimeoutMs(50000)
            .retryPolicy(new ExponentialBackoffRetry(50000, 3))
            .build();
    private static String master_path = "/curator_recipes_master_path";
    private static String lock_path = "/curator_recipes_lock_path";
    private static String distatomicint_path = "/curator_recipes_distatomicint_path";
    public static CyclicBarrier barrier = new CyclicBarrier(3);
    private static String barrier_path = "/curator_recipes_barrier_path";
    private static DistributedBarrier distributedBarrier;

    public static void main(String[] args) throws Exception{
        test7();
    }

    public static void test7() throws Exception{
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {


                @Override
                public void run() {
                    try {
                        CuratorFramework client = CuratorFrameworkFactory.builder()
                                .connectString(host)
                                .sessionTimeoutMs(50000)
                                .retryPolicy(new ExponentialBackoffRetry(50000, 3)).build();
                        client.start();
                        distributedBarrier = new DistributedBarrier(client, barrier_path);
                        System.out.println(Thread.currentThread().getContextClassLoader() + "号barrier设置");
                        distributedBarrier.setBarrier();
                        distributedBarrier.waitOnBarrier();
                        System.out.println("启动。。。");
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        Thread.sleep(100000);
        distributedBarrier.removeBarrier();
    }

    @Data
    static class Runner implements Runnable {

        private String name;

        public Runner(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + "准备好了。");
            try {
                ZkCuratorTest.barrier.await();
            }catch (Exception e) {
            }
            System.out.println(name + "起跑!");
        }
    }

    public static void test6() throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Thread(new Runner("1号选手")));
        executorService.submit(new Thread(new Runner("2号选手")));
        executorService.submit(new Thread(new Runner("3号选手")));
    }

    public static void test5() throws Exception{
        client.start();
        DistributedAtomicInteger atomicInteger = new DistributedAtomicInteger(client, distatomicint_path,
                new RetryNTimes(3, 1000));
        AtomicValue<Integer> rc = atomicInteger.add(8);
        System.out.println("----------" + rc.postValue());
        System.out.println("----------" + rc.preValue());
        System.out.println("Result:" + rc.succeeded());
    }

    public static void test4() throws Exception{
        client.start();
        final InterProcessMutex lock = new InterProcessMutex(client, lock_path);
        final CountDownLatch down = new CountDownLatch(1);
        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        down.await();
                        lock.acquire();
                    }catch (Exception e) {
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
                    String orderNo = sdf.format(new Date());
                    System.out.println("生成的订单号是：" + orderNo);
                    try {
                        lock.release();
                    }catch (Exception e) {
                    }
                }
            }).start();
        }
        down.countDown();
    }

    public static void test3() throws Exception{
        client.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                LeaderSelector selector = new LeaderSelector(client, master_path,
                        new LeaderSelectorListenerAdapter() {
                            @Override
                            public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
                                System.out.println("成为Master角色---");
                                Thread.sleep(3000);
                                System.out.println("完成Master操作，释放Master权利");
                            }
                        });
                selector.autoRequeue();
                selector.start();
            }
        }).start();
    }

    public static void test2() throws Exception{
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(host)
                .sessionTimeoutMs(50000)
                .retryPolicy(new ExponentialBackoffRetry(50000, 3))
                .build();
        client.start();
        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .forPath("/zk-book1/c1", "init".getBytes());
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/zk-book1/c1");
        client.delete().deletingChildrenIfNeeded()
                .withVersion(stat.getVersion())
                .forPath("/zk-book1/c1");

    }

    public static void test1() throws Exception{
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(host)
                .sessionTimeoutMs(50000)
                .retryPolicy(new ExponentialBackoffRetry(50000, 3))
                .build();
        client.start();
        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .forPath("/zk-book1/c1", "init".getBytes());

    }

    public static void test() throws Exception{
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(host, 5000,
                3000, retryPolicy);
        client.start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
