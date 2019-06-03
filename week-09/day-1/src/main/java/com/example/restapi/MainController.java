package com.example.restapi;

import com.example.restapi.models.*;
import org.springframework.web.bind.annotation.*;

import java.lang.Error;

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
    public Object appendA(@PathVariable String appendable) {

        Append append = new Append(appendable);
        return append;
    }

    @PostMapping("dountil/{action}")
    public Object doUntil(@PathVariable String action, @RequestBody Json jo) {
        if (jo != null) {
            Until counter = new Until(jo.getUntil(), action);
            return counter;
        } else {
            Error error = new Error("Please provide a number!");
            return error;
        }
    }

    @PostMapping("/arrays")
    public Object arrayHandler(@RequestBody ArayJSON json) {
        if (json.getWhat() != null && json.getNumbers().length > 0) {
            if (!json.getWhat().equals("double")) {
                Calculator calculator = new Calculator(json.getWhat(), json.getNumbers());
                return calculator;
            } else {
                ArrayCalculator arrayCalculator = new ArrayCalculator(json.getNumbers());
                return arrayCalculator;
            }
        } else {
            Error error = new Error("Please provide what to do with the numbers!");
            return error;
        }
    }
}

