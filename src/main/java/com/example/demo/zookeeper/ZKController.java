package com.example.demo.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("zk")
public class ZKController {
    @Autowired
    private ZkClient zkClient;

//    @RequestMapping("test")
//    public String testZK(){
//        List<String> children = zkClient.getChildren("/");
//        children.stream().forEach(s -> {
//            System.out.println(s);
//        });
//        return "success";
//    }
//
//    @RequestMapping("testWatch")
//    public String testZKClient(){
//        zkClient.subscribeDataChanges("/testWatch", new IZkDataListener() {
//            @Override
//            public void handleDataChange(String s, Object o) throws Exception {
//                System.out.println("handleDataChange String is ="+s);
//                System.out.println("handleDataChange Object is ="+ o.toString());
//            }
//
//            @Override
//            public void handleDataDeleted(String s) throws Exception {
//                System.out.println("handleDataDeleted String is ="+s);
//            }
//        });
//        zkClient.subscribeChildChanges("/testWatch", new IZkChildListener() {
//            @Override
//            public void handleChildChange(String s, List<String> list) throws Exception {
//                System.out.println("handleChildChange String is ="+s);
//                list.stream().forEach(temp -> {
//                    System.out.println(temp);
//                });
//            }
//        });
//        zkClient.subscribeStateChanges(new IZkStateListener() {
//            @Override
//            public void handleStateChanged(Watcher.Event.KeeperState keeperState) throws Exception {
//                System.out.println(keeperState.getIntValue());
//            }
//
//            @Override
//            public void handleNewSession() throws Exception {
//                System.out.println("handleNewSession");
//
//            }
//
//            @Override
//            public void handleSessionEstablishmentError(Throwable throwable) throws Exception {
//                System.out.println("handleSessionEstablishmentError");
//                throwable.printStackTrace();
//            }
//        });
//
//        return "success";
//    }
//
//    @RequestMapping("createLockParentNode")
//    public String createLockParentNode(){
//        zkClient.createPersistent("/lock");
//
//        return "success";
//    }

    @RequestMapping("testLock")
    public String testLock(String path) throws InterruptedException {
        MyZKDistrubuteLock lock = new MyZKDistrubuteLock();
        lock.getLock();
        TimeUnit.SECONDS.sleep(10);
        lock.unLock();
        return "success";
    }
}
