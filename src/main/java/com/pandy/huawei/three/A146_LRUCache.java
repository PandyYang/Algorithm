package com.pandy.huawei.three;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class A146_LRUCache {
    private int cap;

    private HashMap<Integer, Integer> map = new LinkedHashMap<>();

    public A146_LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new LinkedHashMap<Integer, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cap;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);

    }
}
