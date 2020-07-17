package com.example.demo.dubbo;

import com.alibaba.dubbo.common.utils.ConcurrentHashSet;
import com.alibaba.dubbo.config.annotation.Reference;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("dubbo")
public class DubboController {
//    如果像这样配置了指定url，那么注册中心不启动也可以@Reference(url = "dubbo://10.10.2.75:20880/com.example.demo.dubbo.ProviderService?accesslog=true&anyhost=true&application=service-provider&default.delay=-1&default.retries=1&delay=-1&dubbo=2.6.2&generic=false&interface=com.example.demo.dubbo.ProviderService&loadbalance=random&methods=getName&pid=98701&side=provider&timestamp=1594983022753")
    @Reference
    private ProviderService providerService;
    @Autowired
    private ZkClient zkClient;

    private Set<String> providerIpSet = new ConcurrentHashSet<>();

    @RequestMapping("/name")
    public String getName(){
        return providerService.getName("凤年");
    }


    @RequestMapping("/getProviderIpSet")
    public Object getProviderIpSet(){
        List<String> children = zkClient.getChildren("/dubbo/com.example.demo.dubbo.ProviderService/providers");

        return children;
    }




    @PostConstruct
    public void listenZKRegistNode(){
        System.out.println("================== start Listen ==================");
        zkClient.subscribeDataChanges("/dubbo", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("handleDataChange String is ="+s);
                System.out.println("handleDataChange Object is ="+ o.toString());

                providerIpSet.add(o.toString());
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
//                System.out.println("handleDataDeleted String is ="+s);
//                providerIpSet.remove(s);
            }
        });
    }


}
