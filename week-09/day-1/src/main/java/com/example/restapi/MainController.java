package com.example.restapi;

import com.example.restapi.models.Append;
import com.example.restapi.models.Doubling;
import com.example.restapi.models.Greeter;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @GetMapping("/doubling")
    public Object doubling(@RequestParam(required = false) Integer input) {
        if (input != null) {
            Doubling doubling = new Doubling(input);

            return doubling;
        } else {
            Error newError = new Error("Please provide an input!");
            return newError;
        }
    }

    @GetMapping("/greeter")
    public Object greeting(@RequestParam(required = false) String name, @RequestParam(required = false) String title) {
        if (name == null && title == null) {
            Error newError = new Error("Please provide a name and a title!");
            return newError;
        }
        if (name == null) {
            Error newError = new Error("Please provide a name!");
            return newError;
        }

        if (title == null) {
            Error newError = new Error("Please provide a title!");
            return newError;
        }
        Greeter greet = new Greeter(name, title);
        return greet;
    }

    @GetMapping("/appenda/{appendable}")
    public Object appendA (@PathVariable String appendable){

        Append append = new Append(appendable);
        return append;
    }
}

