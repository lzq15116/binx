package com.liyuan.binx.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/home")
@RestController
public class HomeControllor {

    @GetMapping("/")
    public String home(HttpServletRequest request) {
//        System.out.println(request.getAttribute("token").toString());
        return "Hello World!";
    }

    @GetMapping("/world")
    public String world(String q) {
//        System.out.println(request.getAttribute("token").toString());
        System.out.println(q);
        return " World!";
    }
}
