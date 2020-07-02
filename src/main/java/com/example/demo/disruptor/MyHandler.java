package com.example.demo.disruptor;


import com.lmax.disruptor.EventHandler;
import net.sf.json.JSONObject;

import java.util.concurrent.TimeUnit;

public class MyHandler implements EventHandler<MyEvent> {

    @Override
    public void onEvent(MyEvent myEvent, long l, boolean b) throws Exception {
        System.out.println(l +"  "+b+"  enter handler "+ JSONObject.fromObject(myEvent).toString());
        TimeUnit.SECONDS.sleep(5);
        System.out.println("enter end "+ l +"  "+b);
    }
}
