package com.example.demo.proxy;

public class TestProxy {
    public static void main(String[] args) {
        StudentProxy stu = new StudentProxy();
        Student student = (Student) stu.bind(new StudentImpl());
        StudentGoHomeProxy goHomeProxy = new StudentGoHomeProxy();
        student = (Student)goHomeProxy.bind(student);
        student.study();
    }
}
