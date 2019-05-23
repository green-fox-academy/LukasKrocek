package com.example.foxes.services;


import com.example.foxes.models.Fox;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoxStateService {
    private List<Fox> foxes = new ArrayList<>();

    public List<Fox> getFoxes() {
        return foxes;
    }

    public boolean foxExists(String name) {
        for (Fox fox : foxes) {
            if (fox.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Fox findFoxByName(String name) {
        return foxes.stream()
                .filter(f -> f.getName().equals(name))
                .findAny()
                .get();
    }

    public void addFox(String name) {
        foxes.add(new Fox(name));
    }
}
