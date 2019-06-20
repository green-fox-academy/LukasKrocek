package com.example.trialexam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Random;

@Entity
@Getter
@Setter
public class Link {

    @Id
    @GeneratedValue
    private Long id;
    private String url;
    private String alias;
    private Long hitCount;
    @JsonIgnore
    private String secretCode;

    public Link() {
    }

    public Link(String url, String alias) {
        this.url = url;
        this.alias = alias;
        hitCount = 0L;
        this.secretCode = getRandomCode();
    }

    private String getRandomCode() {
        String code = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            code += random.nextInt(9);
        }
        return code;
    }

    public void incrementHitCount() {
        hitCount++;
    }
}
