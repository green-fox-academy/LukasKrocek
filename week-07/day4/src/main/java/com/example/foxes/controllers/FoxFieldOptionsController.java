package com.example.foxes.controllers;

import com.example.foxes.services.FoxFieldOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Controller //managing possible fields(tricks,meals,drinks), add/delete/modify
public class FoxFieldOptionsController {

    FoxFieldOptionsService fieldService;

    @Autowired
    public FoxFieldOptionsController (FoxFieldOptionsService fieldService){
        this.fieldService = fieldService;
    }
}
