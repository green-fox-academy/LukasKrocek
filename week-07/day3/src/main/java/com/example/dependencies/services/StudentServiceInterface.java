package com.example.dependencies.services;

import java.util.List;

public interface StudentServiceInterface {
    List<String> findAll();

    void save(String student);

    int countStudents();
}
