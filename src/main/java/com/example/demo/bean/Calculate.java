package com.example.demo.bean;

import com.example.demo.annotation.MyAnnotation;

//@Component
public class Calculate {

    public int doAdd(int a){
        System.out.println(this);
        return this.add(a);
    }

    @MyAnnotation
    public int add(int a){
        System.out.println("======"+this);

        return 1+a;
    }

}
