package com.example.demo.counter;

import com.example.demo.cache.Cache;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Counter {

    private static final Logger log = Logger.getLogger(Counter.class);

    private static AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public AtomicInteger getCounter() { return counter; }
}
