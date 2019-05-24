package com.example.foxes.models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Fox {

    private String name;
    private List<String> tricks;
    private List<String> changes;
    private String meal;
    private String drink;

    public Fox(String name) {
        this.name = name;
        tricks = new ArrayList<>();
        changes = new ArrayList<>();
        meal = "default food";
        drink = "default drink";
        addChange("Created");
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

    public List<String> getChanges() {
        return changes;
    }

    public void setMeal(String meal) {
        addChange("Meal changed from " + this.meal + " to " + meal);
        this.meal = meal;
    }

    public void setDrink(String drink) {
        addChange("Drink changed from " + this.drink + " to " + drink);

        this.drink = drink;
    }

    public void addTrick(String trick) {
        addChange(trick + " trick added.");
        tricks.add(trick);
    }

    private void addChange(String changeDescription) {
        changes.add(changeDescription + ", At: " + LocalTime.now().toString());
    }
}
