package com.example.demo.disruptor;

import com.lmax.disruptor.EventFactory;

public class MyEventFactory implements EventFactory<MyEvent> {
    @Override
    public MyEvent newInstance() {
        return new MyEvent();
    }
}
