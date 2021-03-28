package com.github.spring.boot.zookeeper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

/**
 * TODO
 * <p>
 * create in 2021/3/26 11:03 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
class TestZookeeper {

    private static final String CONNECTION_ADDR = "172.21.44.173:2181,172.21.44.241:2181";

    @Test
    void test1() throws Exception {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper(CONNECTION_ADDR, 4000, event -> {
            if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
                //如果收到了服务端的响应事件，连接成功
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        //CONNECTED
        System.out.println(zooKeeper.getState());
    }

    @Test
    void test2() throws Exception {
        ZooKeeper zooKeeper = getZooKeeper();
        for (String child : zooKeeper.getChildren("/brokers", false)) {
            byte[] data = zooKeeper.getData("/brokers/" + child, false, new Stat());
//            zooKeeper.addAuthInfo("digest","userkafka:userkafka".getBytes());
            log.info(new String(data));
            System.out.println(new String(data));
        }
    }

    @Test
    void test3() throws Exception {
        ZooKeeper zooKeeper = getZooKeeper();
        for (String child : zooKeeper.getChildren("/zookeeper", false)) {
            byte[] data = zooKeeper.getData("/zookeeper/" + child, false, new Stat());
            log.info(new String(data));
            System.out.println(new String(data));
        }
    }

    @Test
    void test4() throws Exception {
        ZooKeeper zooKeeper = getZooKeeper();
//        zooKeeper.addAuthInfo("digest","userkafka:passkafka".getBytes());
        byte[] data = zooKeeper.getData("/brokers/ids/0", false, new Stat());
        System.out.println(new String(data));
    }












    @SneakyThrows
    private ZooKeeper getZooKeeper() {
        return new ZooKeeper(CONNECTION_ADDR, 4000, event -> {
            if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
//                System.out.println(event.getPath());
            }
        });
    }


}
