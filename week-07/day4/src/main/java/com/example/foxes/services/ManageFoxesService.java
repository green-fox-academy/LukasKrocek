package com.example.foxes.services;

import com.example.foxes.models.Fox;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //managing fox list (adding, deleting, searching)
public class ManageFoxesService {
    private List<Fox> foxes = new ArrayList<>();

    public List<Fox> getFoxes() {
        return foxes;
    }

    public void addFox(String name) {
        foxes.add(new Fox(name));
    }

    public void deleteFox(String name) {
        for (Fox fox : foxes) {
            if (fox.getName() == name) {
                foxes.remove(fox);
            }
        }
    }

    public Fox getFoxByName(String foxName) {
        for (Fox fox : foxes) {
            if (fox.getName().equals(foxName)) {
                return fox;
            }
        }
        return null;
    }

    public boolean foxExists(String name) {
        for (Fox fox : foxes) {
            if (fox.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
