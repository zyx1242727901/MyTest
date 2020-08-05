package com.example.demo.rocketmq;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@RocketMQTransactionListener(txProducerGroup = "tansaction-group")
public class TransacionListenerImpl implements RocketMQLocalTransactionListener {
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        System.out.println("本地事务及消息发送"+ JSONObject.toJSONString(new String((byte[]) message.getPayload())));
        try {
            //本地事务执行
            System.out.println("模拟本地事务执行");
//            int i = 1 / 0;
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            System.out.println("模拟本地事务报错");
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        System.out.println("回查消息"+ JSONObject.toJSONString(new String((byte[]) message.getPayload())));

        return RocketMQLocalTransactionState.UNKNOWN;
    }
}
