package com.example.demo.main;

public class FinalizeObj {

    @Override
    protected void finalize() throws Throwable {
        TestFinalize.list.add(this);
    }
}
