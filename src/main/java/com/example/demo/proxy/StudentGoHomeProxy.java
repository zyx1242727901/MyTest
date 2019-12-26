package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StudentGoHomeProxy implements InvocationHandler {
    private Object obj;

    public Object bind(Object object){
        this.obj = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("从家里出来");
        method.invoke(obj, args);
        System.out.println("肥家！");
        return null;
    }
}
