package com.example;

import org.junit.jupiter.api.Test;

public class RegexTest {

    @Test
    void replaceIntsWithFloatsTest() {
        String exp = "(4+51)/(20*2)*2.5";
        exp = exp.replaceAll("(?<![.\\w])\\d+(?![.\\w])", "$0d");
        System.out.println(exp);
    }
    
}