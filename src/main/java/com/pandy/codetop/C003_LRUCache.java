package com.pandy.codetop;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class C003_LRUCache {

    private int cap;
    private Map<Integer, Integer> map = new LinkedHashMap<>();

    public C003_LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (map.keySet().contains(key)) {
            Integer v = map.get(key);
            map.remove(v);
            map.put(key, v);
            return v;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.keySet().contains(key)) {
            map.remove(key);
            map.put(key, value);
            // 到达容量 要清空最旧的元素
        }else if (map.size() == cap) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
                map.put(key,value);
            }
        }
    }
}
