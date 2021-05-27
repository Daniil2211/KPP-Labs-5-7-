package com.example.demo.service;

import com.example.demo.exceptions.RequestException;
import com.example.demo.exceptions.ServerException;

public interface MyService<T, E, D> {
    T doService (E enity1, D enity2) throws ServerException;
}
