package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {
    @RequestMapping(value = "/greeting")
    public Greetings greeting(@RequestParam String name) {
        return new Greetings("Hello " + name);
    }
}
