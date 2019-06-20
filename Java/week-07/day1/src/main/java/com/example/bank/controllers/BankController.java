package com.example.bank.controllers;


import com.example.bank.models.AnimalBank;
import com.example.bank.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BankController {

    BankAccount testAccount = new BankAccount("Simba", 2000, "lion", true, true);
    AnimalBank testBank = new AnimalBank();

    @RequestMapping(value = "/show")
    public String showBank(Model model) {
        model.addAttribute("account", testAccount);
        return "show";
    }

    @RequestMapping(value = "/text")
    public String showText(Model model) {
        model.addAttribute("utext", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
        model.addAttribute("text", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");

        return "text";
    }

    @RequestMapping(value = "/list")
    public String showList(Model model) {
        model.addAttribute("newAccount", new BankAccount());
        model.addAttribute("accountList", testBank.getAccounts());
        return "list";
    }

    @RequestMapping(value = "/increment")
    public String increment(Model model, @RequestParam String animal) {
        testBank.incrementAccountBalance(animal);
        model.addAttribute("accountList", testBank.getAccounts());
        model.addAttribute("newAccount", new BankAccount());
        return "list";
    }

    @PostMapping("/handle-the-form")
    public String handle(@ModelAttribute BankAccount account,
                         Model model) {
        model.addAttribute("newAccount", account);
        testBank.addAccount(account);
        model.addAttribute("accountList", testBank.getAccounts());
        return "list";
    }
}

