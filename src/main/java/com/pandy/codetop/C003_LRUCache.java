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
            Integer value = map.remove(key); // 正确地移除key
            map.put(key, value); // 然后将其重新放入map，确保它在末尾
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() == cap) {
            Integer firstKey = map.keySet().iterator().next(); // 直接获取第一个键
            map.remove(firstKey); // 移除最早的元素
        }
        map.put(key, value); // 添加新元素或更新旧元素的位置
    }

}
