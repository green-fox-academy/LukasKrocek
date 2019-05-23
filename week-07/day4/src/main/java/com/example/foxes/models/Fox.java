package com.example.foxes.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Fox {

    private String name;
    private List <String> tricks;
    private String food;
    private String drink;

    public Fox(String name) {
        this.name = name;
        tricks = new ArrayList<>();
        tricks.add("Created");
        tricks.add("Good Fox");
        food = "default food";
        drink = "default drink";
    }

    public String getName() {
        return name;
    }

    public List<String> getTricks() {
        return tricks;
    }

    public String getFood() {
        return food;
    }

    public String getDrink() {
        return drink;
    }

    public void setTricks(List<String> tricks) {
        this.tricks = tricks;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void addTrick (String trick){
        tricks.add(trick);
    }
}
