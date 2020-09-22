package com.example.demo.rocketmq;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.util.SerializationUtils;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Consumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("order-producer");
//        consumer.setNamesrvAddr("39.105.95.181:9876");
        consumer.setNamesrvAddr("10.10.1.239:9876");

        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//        consumer.subscribe("topicOrder", "tagOrder");
        consumer.subscribe("topicDelay","tagDelay");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                list.stream().forEach(messageExt->{
//                    System.out.println(Instant.now().getEpochSecond());
                    byte[] body = messageExt.getBody();
                    System.out.println(messageExt.getQueueId()+"==="+new String(body));
                    System.out.println(SerializationUtils.deserialize(body));
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }

        });

        consumer.start();
        System.out.println("consumer.start()");
    }
}
