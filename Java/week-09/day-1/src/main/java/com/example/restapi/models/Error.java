package com.example.restapi.models;

import lombok.Getter;

@Getter
public class Error {

    String error;

    public Error(String error) {
        this.error = error;
    }
}
