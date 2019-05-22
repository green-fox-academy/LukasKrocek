package com.example.dependencies.controllers;

import com.example.dependencies.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BackgroundController {

    UtilityService utilityService;

    @Autowired
    public BackgroundController (UtilityService background){
        this.utilityService = background;
    }


    @RequestMapping (value = "/useful")
    public String homePage (Model model, @RequestParam(value = "text",required = false) String text, @RequestParam(value="number",required = false,defaultValue = "-1") int number){
        if (text != null && number !=-1){
            model.addAttribute("cesar",utilityService.caesar(text,number));
        }
        model.addAttribute("randomColor", "background-color:" + utilityService.randomColor());
        return "index";
    }

}
