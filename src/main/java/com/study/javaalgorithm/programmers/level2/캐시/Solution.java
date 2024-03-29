package com.study.javaalgorithm.programmers.level2.캐시;

import java.util.*;

public class Solution {
    public int solution(int cacheSize, String[] cities) {

        CacheQueue<String> cacheQueue = new CacheQueue<>(cacheSize);

        for (String city : cities) {
            cacheQueue.add(city.toLowerCase(Locale.ROOT));
        }

        return cacheQueue.getDuringTime();
    }
}

class CacheQueue<E> {
    private int cacheSize;
    private Queue<E> queue;
    private Map<E, Integer> keyMap;
    private int duringTime;

    public CacheQueue(int cacheSize) {
        this.cacheSize = cacheSize;
        this.queue = new LinkedList<>();
        this.keyMap = new HashMap<>();
        this.duringTime = 0;
    }

    public void add(E key) {
        duringTime = keyMap.containsKey(key) ? duringTime + 1 : duringTime + 5;

        if (cacheSize == 0) {
            return;
        }

        if (!keyMap.containsKey(key) && queue.size() == cacheSize) {
            E poll = queue.poll();
            keyMap.remove(poll);
        } else if (keyMap.containsKey(key)) {
            queue.remove(key);
            keyMap.remove(key);
        }

        queue.add(key);
        keyMap.put(key, 0);
    }

    public int getDuringTime() {
        return duringTime;
    }
}
