package com.xuzhongjian;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zjxu97 at 3/2/21 3:59 PM
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return this.size() > capacity;
            }
        };
    }

    public int get(int key) {
        Integer integer = map.get(key);
        if (Objects.isNull(integer)) {
            return -1;
        }
        return integer;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}