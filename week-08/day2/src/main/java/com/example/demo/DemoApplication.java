package com.example.demo;

import com.example.demo.models.ToDo;
import com.example.demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private ToDoRepository repository;

    @Autowired
    public DemoApplication(ToDoRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new ToDo("Make it Happen"));
        repository.save(new ToDo("Make it Happen twice"));
        repository.save(new ToDo("Third Task"));
        repository.save(new ToDo("Forth One, its getting serious!"));
    }
}

