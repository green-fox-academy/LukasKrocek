package com.example.bank.models;

import java.util.ArrayList;
import java.util.List;

public class AnimalBank {

    private List<BankAccount> accounts;

    public AnimalBank() {
        accounts = new ArrayList<>();
        accounts.add(new BankAccount("Pikachu", 1000, "Pokemon",true, false));
        accounts.add(new BankAccount("Ferda", 850, "Ant",false,true));
        accounts.add(new BankAccount("Mikes", 500, "Cat",true,true));
        accounts.add(new BankAccount("Scooby Doo", 2000, "Dog",false,false));
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void incrementAccountBalance (String ownerName){
        for (BankAccount account: accounts) {
            if(account.getName().toLowerCase().equals(ownerName.toLowerCase())){
                account.setBalance(account.getBalance()+10);
            }
        }
    }
    public void addAccount (BankAccount newAccount){
        accounts.add(newAccount);
    }
}
