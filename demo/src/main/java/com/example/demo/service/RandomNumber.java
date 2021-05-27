package com.example.demo.service;

import com.example.demo.Statistic.Statistic;
import com.example.demo.exceptions.RequestException;
import com.example.demo.exceptions.ServerException;
import com.example.demo.cache.Cache;
import com.example.demo.query.Query;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class RandomNumber implements MyService<RandomNumber, Stream<Integer>, Stream<Boolean>> {

    @Autowired
    private Cache cache;

    @Autowired
    private Statistic statistic;

    private static final Logger log = Logger.getLogger(RandomNumber.class);

    private int number;

    public RandomNumber() {
        this.number = (int) (Math.random() * 1000);
    }

    @Override
    public RandomNumber doService(Stream<Integer> stream1, Stream<Boolean> stream2) throws ServerException {

        Integer num = stream1.collect(Collectors.toList()).get(0);
        Boolean MoreOrLess = stream2.collect(Collectors.toList()).get(0);

        Query query = new Query(num, MoreOrLess);

        if (cache.getNum(query) != null) {
            this.number = cache.getNum(query);
        } else {
            if (MoreOrLess) {
                number = num + (int) (Math.random() * (1000 - num));
            } else {
                number = (int) (Math.random() * num);
            }
            if (!MoreOrLess && number > num || MoreOrLess && number < num) {
                log.error("Bad random number");
                throw new ServerException("Bad random number");
            }

            cache.putNum(query, number);
        }
        return this;
    }

    private void CountSize(int num) {

        int num1=cache.getMaxLen();
        int num2=cache.getMinLen();
        float num3=cache.getAverage();
        statistic.setStatistic(num1, num2, num3);
    }


}

    /*public void generateNumber(int num, boolean MoreOrLess) throws ServerException {

        Query query = new Query(num, MoreOrLess);

        if(cache.getNum(query) != null) {
            this.number = cache.getNum(query);
        }
        else {
            if (MoreOrLess) {
                number = num + (int) (Math.random() * (1000 - num));
            } else {
                number = (int) (Math.random() * num);
            }
            if (!MoreOrLess && number > num || MoreOrLess && number < num) {
                log.error("Bad random number");
                throw new ServerException("Bad random number");
            }

            cache.putNum(query, number);
        }
    }

    public long getNumber() {
        return number;
    }
}*/


/*@Service
public class RandomNumber {

    @Autowired
    private Cache cache;

    private static final Logger log = Logger.getLogger(RandomNumber.class);

    private int number;

    public RandomNumber() {
        this.number = (int)(Math.random()*1000);
    }

    public void generateNumber(int num, boolean MoreOrLess) throws ServerException {

        Query query = new Query(num, MoreOrLess);

        if(cache.getNum(query) != null) {
            this.number = cache.getNum(query);
        }
        else {
            if (MoreOrLess) {
                number = num + (int) (Math.random() * (1000 - num));
            } else {
                number = (int) (Math.random() * num);
            }
            if (!MoreOrLess && number > num || MoreOrLess && number < num) {
                log.error("Bad random number");
                throw new ServerException("Bad random number");
            }

            cache.putNum(query, number);
        }
    }

    public long getNumber() {
        return number;
    }

}*/
