package com.example.dependencies;

import com.example.dependencies.services.MyColor;
import com.example.dependencies.services.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependenciesApplication implements CommandLineRunner {

    private Printer printer;
    private MyColor color1;
    private MyColor color2;

    @Autowired
    DependenciesApplication(Printer printer, @Qualifier("red") MyColor color1, @Qualifier("blue") MyColor color2) {
        this.printer = printer;
        this.color1 = color1;
        this.color2 = color2;
    }

    public static void main(String[] args) {
        SpringApplication.run(DependenciesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        printer.log("hello");
        color1.printColor();
        color2.printColor();
    }
}
