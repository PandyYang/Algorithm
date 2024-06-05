package com.pandy.huawei.shousi;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private int cap;
    private Map<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int cap) {
        this.cap = cap;
    }

    public int get(int key) {
        if (map.keySet().contains(key)) {
            Integer remove = map.remove(key);
            map.put(key, remove);
            return remove;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 先判断是否有这个key
        if (map.containsKey(key)) {
            map.put(key, value);
            return;
        }
        if (map.size() == this.cap) {
            // 移除第一个元素
            for (int firstKey : map.keySet()) {
                map.remove(firstKey);
                break;
            }
        }
        map.put(key, value);
    }
}
