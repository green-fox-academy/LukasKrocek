package com.example.foxes.controllers;

import com.example.foxes.models.Fox;
import com.example.foxes.services.FoxFieldOptionsService;
import com.example.foxes.services.FoxStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller //managing fox fields (add/change)
public class FoxController {

    FoxStateService foxState;
    FoxFieldOptionsService fieldService;

    @Autowired
    public FoxController(FoxStateService foxState, FoxFieldOptionsService fieldService) {
        this.foxState = foxState;
        this.fieldService = fieldService;
    }

    @GetMapping(value = "/ChangeNutrition")
    public String returnNutritionStore(@RequestParam String name, Model model) {
        model.addAttribute("meals", fieldService.getAvailableOptionsFromClass(name,"meal"));
        model.addAttribute("drinks", fieldService.getAvailableOptionsFromClass(name,"drink"));
        return "nutritionStore";
    }

    @PostMapping(value = "/ChangeNutrition")
    public String changeNutrition(@RequestParam String name, @RequestParam String meal, @RequestParam String drink) {
        foxState.changeNutrition(name, meal, drink);
        return "redirect:?name=" + name;
    }


    @GetMapping(value = "/TrickCenter")
    public String returnTrickCenter(@RequestParam String name, Model model) {
        model.addAttribute("tricks", fieldService.getAvailableOptionsFromClass(name,"trick"));
        return "trickCenter";
    }

    @PostMapping(value = "/TrickCenter")
    public String addTrick(@RequestParam String name, @RequestParam String trick) {
        for (Fox fox : foxState.getFoxes()) {
            if (fox.getName().equals(name))
                fox.addTrick(trick);
        }
        return "redirect:?name=" + name;
    }


}
