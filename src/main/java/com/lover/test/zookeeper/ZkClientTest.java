package com.lover.test.zookeeper;

import org.I0Itec.zkclient.ZkClient;

/**
 * @author Jack
 * @date 2020/8/13 17:43
 */
public class ZkClientTest {

    final static String host = "192.168.86.248:2181,192.168.86.249:2181,192.168.86.250:2181";

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(host, 30000);
        System.out.println("zookeeper session established.");
    }
}
