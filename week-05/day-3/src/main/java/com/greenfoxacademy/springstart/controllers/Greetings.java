package com.greenfoxacademy.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;

public class Greetings {

    private static AtomicLong id = new AtomicLong();
    private String content;

    public Greetings(String content) {
        this.content = content;
        id.incrementAndGet();
    }
    public AtomicLong getId() {
        return id;
    }

    public static Long incrementAndGet (){
        return id.incrementAndGet();

    }

    public String getContent() {
        return content;
    }
}
