package com.pandy.error;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Auther: huhua
 * @Date: 2021/3/4
 */

public class TestDump {

    public static void main(String[] args) throws Exception {
        Integer size = 1024 * 1024 * 8 ;
        List<byte[]> list = new ArrayList<byte[]>();
        for(int a=1; a<1000000; a++){
            list.add(new byte[size]);
        }
 
    }
}