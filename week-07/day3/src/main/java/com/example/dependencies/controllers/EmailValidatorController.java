package com.example.dependencies.controllers;

import com.example.dependencies.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailValidatorController {

    UtilityService utilityService;

    @Autowired
    public EmailValidatorController (UtilityService utilityService){
        this.utilityService = utilityService;
    }

    @RequestMapping(value = "/useful/email")
    public String emailCheck(@RequestParam String email, Model model) {
        if (utilityService.validateEmail(email)){
            model.addAttribute("emailvalidation", email + " is a valid email address");
            model.addAttribute("color", "Color: Green");
        }
        else {
            model.addAttribute("emailvalidation", email + " is not a valid email address");
            model.addAttribute("color", "Color: Red");
        }

        return "emailcheck";
    }
}
