package com.example.foxes.controllers;

import com.example.foxes.models.Fox;
import com.example.foxes.models.Enums;
import com.example.foxes.services.FoxStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FoxController {

FoxStateService foxState;

@Autowired
public FoxController (FoxStateService foxState){
    this.foxState = foxState;
}

    @GetMapping(value = "/ChangeNutrition")
    public String returnNutritionStore(@RequestParam String name, Model model) {
        model.addAttribute("meals", Enums.meals.values());
        model.addAttribute("drinks", Enums.drinks.values());
        return "nutritionStore";
    }

    @PostMapping(value = "/ChangeNutrition")
    public String changeNutrition(@RequestParam String name, @RequestParam String meal, @RequestParam String drink) {
        for (Fox fox : foxState.getFoxes()) {
            if (fox.getName().equals(name))
                fox.setFood(meal);
            fox.setDrink(drink);
        }
        return "redirect:?name=" + name;
    }


    @GetMapping(value = "/TrickCenter")
    public String returnTrickCenter(@RequestParam String name, Model model) {
        model.addAttribute("tricks", Enums.tricks.values());
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
