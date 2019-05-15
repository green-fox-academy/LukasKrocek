package com.greenfoxacademy.springstart.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Greetings {

    private static AtomicLong id = new AtomicLong();
    private String content;
    private static String language;

    public Greetings(String content) {
        this.content = content;
        id.incrementAndGet();
    }

    public AtomicLong getId() {
        return id;
    }

    public static Long incrementAndGetID() {
        return id.incrementAndGet();

    }

    public static String getRandomHello() {
        String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
                "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
                "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
                "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};
        int indexOFHello = (int) (Math.random() * hellos.length);
        return hellos[indexOFHello];
    }

    public String getContent() {
        return content;
    }
}
