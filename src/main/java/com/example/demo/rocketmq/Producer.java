package com.example.demo.rocketmq;

//
//public class Producer {
//
//    public static void main(String[] args) {
//
//        try {
//            DefaultMQProducer orderProducer = new DefaultMQProducer("order-producer");
//            orderProducer.setNamesrvAddr("39.105.95.181:9876");
//            orderProducer.start();
//            //有序消息=============================
////            for (int i = 1; i <= 5; i++) {
////                int orderId = i;
////                Message message = new Message("topicOrder", "tagOrder", "keyOrder", ("helloWord_"+i).getBytes());
////                SendResult sendResult = orderProducer.send(message, new MessageQueueSelector() {
////                    @Override
////                    public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
////                        Integer index = (Integer) o;
////                        int i = index % list.size();
////                        return list.get(i);
////                    }
////                },orderId);
////            }
//
//
//            //延时消息=============================
////            Message message = new Message("topicDelay", "tagDelay", "keyDelay", ("helloWord_").getBytes());
////            message.setDelayTimeLevel(2);
////            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
////
////            orderProducer.send(message);
////            System.out.println(Instant.now().getEpochSecond());
//
//
//            //事务消息=============================
////            TransactionMQProducer transactionMQProducer = new TransactionMQProducer("rocket-transaction-gourp");
////            transactionMQProducer.setNamesrvAddr("39.105.95.181:9876");
////            transactionMQProducer.setTransactionListener(new TransacionListenerImpl());
////            Message message = new Message("topicTrans", "tagTrans", "keyTrans", ("helloWord_").getBytes());
////
////            orderProducer.sendMessageInTransaction(message, null);
//            ConfigurableApplicationContext context = SpringApplication.run(DemoSpringApplication.class, args);
//
//            RocketMQTemplate template = context.getBean(RocketMQTemplate.class);
////            while (true) {
//                String msg = "ZYX发送消息";
//                System.out.println("开始发送消息："+msg);
//
//                Message message = MessageBuilder.withPayload(msg).build();
//                TransactionSendResult result = template.sendMessageInTransaction("tansaction-group","topicTrans",  message, null);
//                System.out.println("消息发送响应信息："+result.toString());
//
////                Thread.sleep(10);
////            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
