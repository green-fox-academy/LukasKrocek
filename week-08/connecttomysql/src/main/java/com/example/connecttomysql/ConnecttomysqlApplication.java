package com.example.connecttomysql;

import com.example.connecttomysql.models.ToDo;
import com.example.connecttomysql.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnecttomysqlApplication implements CommandLineRunner {

    ToDoRepository repository;



    @Autowired
    public ConnecttomysqlApplication(ToDoRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConnecttomysqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new ToDo("First thing ToDo",false,true));
        repository.save(new ToDo("Second thing ToDo",true,true));
        repository.save(new ToDo("Third thing ToDo",false,false));
        repository.save(new ToDo("Forth thing ToDo",true,false));
    }
}
