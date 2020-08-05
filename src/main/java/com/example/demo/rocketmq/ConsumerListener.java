package com.example.demo.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
@Component
@RocketMQMessageListener(topic = "topicTrans",consumerGroup = "tansaction-group2")
public class ConsumerListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
//        log.info("开始消费消息:{}",s);
        //解析消息为对象
//        final JSONObject jsonObject = JSON.parseObject(s);
//        AccountChangeEvent accountChangeEvent = JSONObject.parseObject(jsonObject.getString("accountChange"),AccountChangeEvent.class);

        //调用service增加账号金额
//        accountChangeEvent.setAccountNo("2");
//        accountInfoService.addAccountInfoBalance(accountChangeEvent);

//        int i = 1 / 0;
        System.out.println("消费消息++"+s);
    }
//
//    @Override
//    public void prepareStart(Object o) {
//
//
//
//        DefaultMQPushConsumer consumer = (DefaultMQPushConsumer) o;
//        consumer.registerMessageListener(new MessageListenerConcurrently() {
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
//                for (MessageExt messageExt : msgs) {
//                    System.out.println("重试次数:" + messageExt.getReconsumeTimes());
//
//                    System.out.println("接受到的消息:" + new String(messageExt.getBody()));
//                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//                }
//
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            }
//        });
//    }
}
