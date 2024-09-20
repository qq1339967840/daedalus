package com.cib.demo.app.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class MyDemoController {
    private static final Logger logger = LoggerFactory.getLogger(MyDemoController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testRequestMapping() {
        return "test OK!";
    }

    @GetMapping("/test2")
    public String test2() {
        return "test2 OK!";
    }

}
