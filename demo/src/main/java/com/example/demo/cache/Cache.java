package com.example.demo.cache;

import com.example.demo.query.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class Cache {

    private static final Logger log = Logger.getLogger(Cache.class);

    private final Map<Query, Integer> cacheMap = new HashMap<>();

    private ArrayList<Integer> length=new ArrayList<>();

    public Integer getNum(Query query) {
        Integer result = cacheMap.get(query);
        log.debug("Get cache");
        return result;
    }

    public void putNum(Query query, Integer number) {
        log.debug("Put cache");
        cacheMap.put(query, number);
    }

    public void putLen(Integer num) {
        length.add(num);
    }

    public Integer getMaxLen() {
        Collections.sort(length);
        return length.get(0);
    }

    public Integer getMinLen() {
        Collections.sort(length);
        return length.get(length.size()-1);
    }

    public float getAverage(){
        float ave = 0;
        for (Integer integer : length) {
            ave += integer;
        }
        return ave/length.size();
    }

}

