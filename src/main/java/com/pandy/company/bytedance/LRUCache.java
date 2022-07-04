package com.pandy.company.bytedance;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Pandy
 * @create: 2022/6/30
 * <p>
 * LRU缓存机制
 * <p>
 * 请你设计并实现一个满足i LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量icapacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)i如果关键字ikey 已经存在，则变更其数据值ivalue ；如果不存在，则向缓存中插入该组ikey-value 。
 * 如果插入操作导致关键字数量超过icapacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 **/
class LRUCache {

    private final int cap;

    private final HashMap<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity, int cap) {
        this.cap = cap;
    }

    /**
     * 因为
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(value);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 查看是否存在
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        } else {
            // 否则查看是否满了
            if (map.size() == cap) {
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                iterator.next();
                iterator.remove();
                map.put(key, value);
            }
        }
    }
}

