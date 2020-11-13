package com.example.demo.singlton;

/**
 * zhangyuxiao
 * 2020/11/11 19:06
 */
public class DoubleCheckSingltonImpl extends DoubleCheckSinglton {
    private volatile static DoubleCheckSingltonImpl doubleCheckSinglton;

    @Override
    public  DoubleCheckSinglton getInstance(){
        return new DoubleCheckSinglton();
    }
}
