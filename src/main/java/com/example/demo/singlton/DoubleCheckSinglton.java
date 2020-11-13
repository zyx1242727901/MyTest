package com.example.demo.singlton;

public class DoubleCheckSinglton {
    //volatile 防止doubleCheckSinglton = new DoubleCheckSinglton()时指令重拍，返回一个只分配了地址没初始化完毕的对象
    private volatile static DoubleCheckSinglton doubleCheckSinglton;

    public  DoubleCheckSinglton getInstance(){
        if(doubleCheckSinglton == null){
            synchronized (DoubleCheckSinglton.class){
                if(doubleCheckSinglton == null) {
                    doubleCheckSinglton = new DoubleCheckSinglton();
                }
            }
        }
        return doubleCheckSinglton;
    }
}
