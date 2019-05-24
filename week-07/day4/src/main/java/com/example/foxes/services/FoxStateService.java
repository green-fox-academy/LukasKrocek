package com.example.foxes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //managing fields of single fox
public class FoxStateService {

    private FoxesManagerService foxManager;

    @Autowired
    public FoxStateService (FoxesManagerService foxManager){
        this.foxManager = foxManager;
    }

    public void changeNutrition(String foxName, String meal, String drink) {

                foxManager.getFoxByName(foxName).setMeal(meal);
                foxManager.getFoxByName(foxName).setDrink(drink);
    }

    public void learnTrick (String foxName, String trickName){
        foxManager.getFoxByName(foxName).addTrick(trickName);
    }
}
