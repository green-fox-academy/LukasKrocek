package com.example.foxes.services;

import com.example.foxes.models.Fox;
import com.example.foxes.models.foxfieldoptions.Drink;
import com.example.foxes.models.foxfieldoptions.FoxFieldOption;
import com.example.foxes.models.foxfieldoptions.Meal;
import com.example.foxes.models.foxfieldoptions.Trick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoxFieldOptionsService {
    List<FoxFieldOption> options;
    FoxStateService foxState;

    @Autowired
    public FoxFieldOptionsService(FoxStateService foxState) {  //creates default options list
        this.foxState = foxState;
        options = new ArrayList<>();
        addOption("meal", "Steak");
        addOption("meal", "Pizza");
        addOption("meal", "Potatoes");
        addOption("meal", "Grass");
        addOption("drink", "Cola");
        addOption("drink", "Pepsi");
        addOption("drink", "Watter");
        addOption("drink", "Vodka");
        addOption("trick", "HTML");
        addOption("trick", "Java");
        addOption("trick", "CSS");
        addOption("trick", "JavaScript");
    }

    public void addOption(String optionClassName, String option) {
        switch (optionClassName) {
            case "meal":
                options.add(new Meal(option));
                break;
            case "drink":
                options.add(new Drink(option));
                break;
            case "trick":
                options.add(new Trick(option));
                break;
            default:
                System.out.println("no such case");
        }
    }

    public List getAllOptionsFromClass(String optionClassName) { //get all drinks, meals or tricks
        return options.stream()
                .filter(foxFieldOption -> foxFieldOption.getFieldClassName().toLowerCase().equals(optionClassName.toLowerCase()))
                .map(foxFieldOption -> foxFieldOption.getFieldOption())
                .collect(Collectors.toList());
    }

    public List getAvailableOptionsFromClass(String foxName, String optionClassName) {
        Fox sampleFox = foxState.getFoxByName(foxName);
        List<String> availableOptionList = getAllOptionsFromClass(optionClassName);
        for (String trick : sampleFox.getTricks()) {
            availableOptionList.remove(trick);
        }
        return availableOptionList;
    }
}