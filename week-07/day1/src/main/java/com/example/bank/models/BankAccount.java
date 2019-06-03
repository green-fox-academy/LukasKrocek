package com.example.bank.models;

public class BankAccount {
    private String name;
    private int balance;
    private String animalType;
    private boolean isKing;
    private boolean goodGuy;

    public BankAccount(String name, int balance, String animalType, boolean isKing, boolean goodGuy) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.isKing = isKing;
        this.goodGuy = goodGuy;
    }

    public void setKing(boolean king) {
        isKing = king;
    }

    public void setGoodGuy(boolean goodGuy) {
        this.goodGuy = goodGuy;
    }

    public BankAccount() {

    }

    public boolean isGoodGuy() {
        return goodGuy;
    }

    public boolean isKing() {
        return isKing;
    }


    public String getDescription() {
        return "name: " + getName() + ", balance: " + getBalance() + ", animal type: " + getAnimalType() + ", King: " + isKing + ", Good Guy: " + goodGuy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void raiseBalance(int raise) {
        balance += raise;
    }


}
