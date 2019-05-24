package com.example.foxes.controllers;

import com.example.foxes.services.FoxFieldOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller //managing possible fields(tricks,meals,drinks), add/delete/modify
public class FoxFieldOptionsController {

    FoxFieldOptionsService fieldService;

    @Autowired
    public FoxFieldOptionsController(FoxFieldOptionsService fieldService) {
        this.fieldService = fieldService;
    }

    @GetMapping("/addOptions")
    public String returnOptionManager(Model model) {
        model.addAttribute("meals", fieldService.getAllOptionsFromClass("meal"));
        model.addAttribute("drinks", fieldService.getAllOptionsFromClass("drink"));
        model.addAttribute("tricks", fieldService.getAllOptionsFromClass("trick"));
        return "optionManager";
    }

    @RequestMapping("/addOptions/{optionClassName}")
    public String addOption(@PathVariable(name="optionClassName") String optionClassName, @RequestParam String optionName) {
        fieldService.addOption(optionClassName,optionName);
        return "redirect:/addOptions";
    }

    }
