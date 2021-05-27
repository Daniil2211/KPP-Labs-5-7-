package com.example.demo.controller;

import com.example.demo.query.Query;
import com.example.demo.service.MyService;
import com.example.demo.service.RandomNumber;
import com.example.demo.exceptions.RequestException;
import com.example.demo.exceptions.ServerException;
import com.example.demo.counter.Counter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

@RestController
public class RandomizerController {

    private static final Logger log = Logger.getLogger(RandomizerController.class);

    @Autowired
    RandomNumber num;

    @Autowired
    Counter counter;

    @Autowired
    private MyService<RandomNumber, Stream<Integer>, Stream<Boolean>> service;

    @GetMapping("/randomizer")
    public RandomNumber randomizer(@RequestParam(value = "number", defaultValue = "100") int number,
                                   @RequestParam(value = "cmp", defaultValue = "true") boolean MoreOrLess)
            throws RequestException, ServerException, IOException {
       if(number >= 1000 || number <= 0) {
           log.error("Bad number");
           throw new RequestException("Bad number");
       }
       FileWriter writer = new FileWriter("file.txt", true);
       num = service.doService(Stream.of(number), Stream.of(MoreOrLess));
       writer.write(String.valueOf(num + "\n"));
       writer.close();
       counter.increment();
       log.debug("Return random number");
       return num;
    }

    @GetMapping("/counter")
    public Counter getCount()
    {
        return counter;
    }

    @PostMapping
    public RandomNumber randomNum(@RequestBody Query query) throws ServerException {
        RandomNumber num = service.doService(Stream.of(query.getNumber()), Stream.of(query.isMoreOrLess()));
        return num;
    }
}
