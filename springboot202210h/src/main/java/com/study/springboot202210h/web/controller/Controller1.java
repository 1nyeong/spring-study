package com.study.springboot202210h.web.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Controller1 {

    @GetMapping("/page1")
    public String page1() {
        return "page1";
    }

    @GetMapping("/page2")
    public String page2(){
        return "page2";
    }
}
