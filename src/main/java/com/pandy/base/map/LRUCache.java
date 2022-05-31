package com.pandy.base.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Pandy
 * @create: 2022/1/1
 **/
public class LRUCache {

    // 缓存容量
    private final int cap;

    private final Map<Integer, Integer> map = new LinkedHashMap<>(); // 保持插入顺序

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // 移除之后再加入，为了确保顺序在前
            int value = map.get(key);
            map.remove(key);
            // 保证每次查询之后都在末尾
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() == cap) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }

}
