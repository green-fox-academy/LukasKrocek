package com.example.restapi.models;

import lombok.Getter;

@Getter
public class Doubling {
    Integer received;
    Integer result;

    public Doubling(Integer received) {
        this.received = received;
        result=received*2;
    }
}
