package com.example.demo.Statistic;

import org.springframework.stereotype.Component;

@Component
public class Statistic {

    private int max;

    private int min;

    private float ave;

    public float getAve() {
        return ave;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public void setStatistic(int max, int min, float ave) {
        this.ave = ave;
        this.min = min;
        this.max = max;
    }
}
