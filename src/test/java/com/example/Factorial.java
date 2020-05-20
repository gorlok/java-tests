package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;

public class Factorial {

    long factorial (int n) {
        return LongStream.rangeClosed(1, n).reduce(1, (long x, long y) -> x * y);
    };

    @Test
    void factorialTest() {
        assertTrue( factorial(5) == 1200L);
    }
    
}