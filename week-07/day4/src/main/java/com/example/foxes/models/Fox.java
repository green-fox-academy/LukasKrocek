package com.example.foxes.models;

import com.example.foxes.models.foxfieldoptions.FoxFieldOption;

import java.util.ArrayList;
import java.util.List;

public class Fox {

    private String name;
    private List <String> tricks;
    private String meal;
    private String drink;

    public Fox(String name) {
        this.name = name;
        tricks = new ArrayList<>();
        meal = "default food";
        drink = "default drink";
    }

    public String getName() {
        return name;
    }

    public List<String> getTricks() {
        return tricks;
    }

    public String getMeal() {
        return meal;
    }

    public String getDrink() {
        return drink;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void addTrick (String trick){
        tricks.add(trick);
    }
}
