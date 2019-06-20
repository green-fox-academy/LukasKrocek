package com.example.dependencies.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("super")
public class StudentStorage implements StudentServiceInterface {
    List<String> names;

    public StudentStorage() {
        names = new ArrayList<>();
        try {
            Path filePath = Paths.get("names.txt");
            names = Files.readAllLines(filePath);
        } catch (Exception e) {
            System.out.println("Uh-oh, could not read the file!");
        }
    }

    @Override
    public List<String> findAll() {
        return names;
    }

    @Override
    public void save(String student) {
        names.add(student);
        try {
            Path filePath = Paths.get("names.txt");
            Files.write(filePath, names);
        } catch (Exception e) {
            System.out.println("Uh-oh, could not write the file!");
        }
    }

    @Override
    public int countStudents() {
        return names.size();
    }
}
