package com.example.demo.rocketmq;

//
//public class Consumer {
//    public static void main(String[] args) throws MQClientException {
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("order-producer");
//        consumer.setNamesrvAddr("39.105.95.181:9876");
//
//        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
////        consumer.subscribe("topicOrder", "tagOrder");
//        consumer.subscribe("topicDelay","tagDelay");
//
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        consumer.registerMessageListener(new MessageListenerConcurrently() {
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
//                list.stream().forEach(messageExt->{
//                    System.out.println(Instant.now().getEpochSecond());
//                    System.out.println(messageExt.getQueueId()+"==="+new String(messageExt.getBody()));
//                });
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            }
//
//        });
//
//        consumer.start();
//        System.out.println("consumer.start()");
//    }
//}
