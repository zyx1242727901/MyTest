package com.example.demo.zookeeper;


import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MyZKDistrubuteLock {

    private ZkClient zkClient = null;

    private String PATH = "/lock";
    /**
     * 当前请求节点的前一个节点
     */
    private String beforePath;
    /**
     * 当前请求的节点
     */
    private String currentPath;

    private CountDownLatch countDownLatch = null;


    public MyZKDistrubuteLock(){
        zkClient = new ZkClient("39.105.95.181:2181", 2000*10, 1000 * 60);
        zkClient.setZkSerializer(new MyZkSerializer());
    }

    private boolean tryLock() {
        // 如果currentPath为空则为第一次尝试拿锁，第一次拿锁赋值currentPath
        if (currentPath == null || currentPath.length() == 0) {
            // 在指定的持久节点下创建临时顺序节点
            currentPath = zkClient.createEphemeralSequential(PATH + "/", "lock");
        }
        // 获取所有临时节点并排序
        List<String> childrenList = zkClient.getChildren(PATH);
        Collections.sort(childrenList);

        if (currentPath.equals(PATH + "/" + childrenList.get(0))) {
            // 如果当前节点在所有节点中排名第一则获取锁成功
            return true;
        } else {
            //获取当前排序
            int wz = Collections.binarySearch(childrenList, currentPath.substring(6));
            beforePath = PATH + "/" + childrenList.get(wz - 1);
            return false;
        }
    }

    private void waitLock() {
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("handleDataDeleted currentPath=" + currentPath + ",beforPath=" + beforePath);
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        };
        //监听前一个节点
        zkClient.subscribeDataChanges(beforePath, listener);

        //如果前节点存在，则等待
        if (zkClient.exists(beforePath)) {
            countDownLatch = new CountDownLatch(1);
            try {
                System.out.println("countDownLatch.await()" + Thread.currentThread().getName());
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //拿到锁后取关监听
        zkClient.unsubscribeDataChanges(beforePath,listener);
    }

    public void unLock(){
        zkClient.delete(currentPath);
        if (zkClient != null) {
            zkClient.close();
        }
    }

    public void getLock(){
        if (tryLock()) {
            System.out.println("拿到了锁，doSomeThing");
        } else {
            //阻塞等待锁
            waitLock();
            //解除阻塞后重新获取
            getLock();
        }
    }
}
