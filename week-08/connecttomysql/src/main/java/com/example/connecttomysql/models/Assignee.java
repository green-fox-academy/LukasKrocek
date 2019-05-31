package com.example.connecttomysql.models;

import javax.persistence.*;

@Entity
public class Assignee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long assigneeID;
    private String name;
    private String email;

    public Assignee(){
    }

    public Assignee(String name) {
        this.name = name;
    }

    public long getAssigneeID() {
        return assigneeID;
    }

    public void setAssigneeID(long assigneeID) {
        this.assigneeID = assigneeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return getName();
    }
}
