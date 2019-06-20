package com.example.restapi.models;

import lombok.Getter;

@Getter
public class Append {

    String appended;

    public Append(String appended) {
        this.appended = appended+"a";
    }
}
