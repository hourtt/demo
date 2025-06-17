package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ExService {

    public String test() {
        System.out.println("ExService.test");
        return "test";
    }
}
