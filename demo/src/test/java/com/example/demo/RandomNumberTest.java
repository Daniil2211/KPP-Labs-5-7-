package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumberTest {
    @Test
    void generateNumber() {

        boolean MoreOrLess = false;
        int num = 100;
        int number;

        if (MoreOrLess) {
            number = num + (int) (Math.random() * (1000 - num));
        } else {
            number = (int) (Math.random() * num);
        }
        Assertions.assertTrue((number < 100) &&
                (number < 1000) &&
                (number > 0));
    }
}