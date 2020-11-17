package com.example.demo.disruptor;

import com.lmax.disruptor.RingBuffer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

public class TestDisruptor {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyDisruptotConfig.class);
        RingBuffer<MyEvent> buffer= (RingBuffer<MyEvent>) ctx.getBean("messageModel");
        for (int i=0;i<5;i++) {
            long sequence = buffer.next();
            System.out.println("sequence="+sequence);
                try {
                    MyEvent myEvent = buffer.get(sequence);
                    myEvent.setMessage("hallo 啊"+i);
                }finally {
                    buffer.publish(sequence);
                }
        }

        System.out.println("主线程结束");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
