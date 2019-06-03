package com.example.restapi.models;

import lombok.Getter;

@Getter
public class Greeter {
    String welcome_message;

    public Greeter(String name, String title) {
        welcome_message = "Oh, hi there "+ name +", my dear "+title+"!";
    }
}
