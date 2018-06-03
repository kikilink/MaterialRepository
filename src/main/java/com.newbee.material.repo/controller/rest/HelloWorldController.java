package com.newbee.material.repo.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloWorldController {

    @RequestMapping(value = "hello",method = {RequestMethod.GET})
    public String test() {
        return "Hello";
    }
}
