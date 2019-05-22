package com.example.dependencies.controllers;

import com.example.dependencies.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackgroundController {

    UtilityService background;

    @Autowired
    public BackgroundController (UtilityService background){
        this.background = background;
    }


    @RequestMapping (value = "/useful")
    public String homePage (Model model){
        model.addAttribute("randomColor", "background-color:" + background.randomColor());
        return "index";
    }

}
