package com.pandy.codetop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private int cap;
    private Map<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
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
            // �������� Ҫ�����ɵ�Ԫ��
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
