package com.example.demo.main;

import com.example.demo.leetcode.Weibo;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * zhangyuxiao
 * 2020/9/18 09:43
 */
public class TestJavaSist {
    public static void main(String[] args) throws NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get(Weibo.class.getName());
        CtMethod[] methods = ctClass.getMethods();
        for (CtMethod method : methods) {
            System.out.println(method.getReturnType());
        }
    }
}
