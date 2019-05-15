package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWebController {
    @RequestMapping("/web/greeting")
    public String greeting(Model model, @RequestParam String name) {
        model.addAttribute("greeting", Greetings.getRandomHello());
        model.addAttribute("name", name); //color: rgb(0,0,255);
        model.addAttribute("style",getRandomRGBString()+getRandomFontSizeString());
        model.addAttribute("id", Greetings.incrementAndGetID());
        return "greeting";
    }

    public String getRandomRGBString() {
        return "color: rgb("
                + (int) (Math.random() * 256) + ","
                + (int) (Math.random() * 256) + ","
                + (int) (Math.random() * 256) + ");";
    }

    public String getRandomFontSizeString() {
        return "font-size:"
                + (int) (Math.random() * 100 + 12) + "px;";
    }
}



