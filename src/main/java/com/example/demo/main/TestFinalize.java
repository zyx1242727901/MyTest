package com.example.demo.main;

import java.util.ArrayList;
import java.util.List;

public class TestFinalize {
    public static List<FinalizeObj> list = new ArrayList<>();


    public static void main(String[] args) {
        List<FinalizeObj> list = new ArrayList<>();
        while(true){
            new FinalizeObj();
        }
    }
}
