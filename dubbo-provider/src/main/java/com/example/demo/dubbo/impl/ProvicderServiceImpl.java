package com.example.demo.dubbo.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.dubbo.ProviderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service(loadbalance = "random",timeout = 50000)
public class ProvicderServiceImpl implements ProviderService {

    @SentinelResource(value="getName",fallback = "sentinelFallBack",blockHandler = "exceptionHandler")
    @Override
    public String getName(String name) {
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Random random = new Random();
        if (random.nextInt(10) > 5) {
            throw new RuntimeException("enne");
        }
        return "徐"+name;
    }

    public String sentinelFallBack(String name,Throwable t){
        System.out.println("==sentinelFallBack==="+name);
        return "Hi sentinelFallBack";
    }

    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public String exceptionHandler(String name, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + name;
    }

    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("getName");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }


}
