package com.eshop.demo.controllers;

import com.eshop.demo.models.ItemStore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebShopController {
    ItemStore store = new ItemStore();

    @RequestMapping(value = "/")
    public String displayAll(Model model) {

        model.addAttribute("items", store.getItems());
        return "webshop";
    }

    @RequestMapping(value = "/only-available")
    public String displayAvailable(Model model) {

        model.addAttribute("items", store.getAvailableItems());
        return "webshop";
    }

    @RequestMapping(value = "/cheapest-first")
    public String displaySorted(Model model) {

        model.addAttribute("items", store.getItemsSortedByPrice());
        return "webshop";
    }

    @RequestMapping(value = "/average-stock")
    public String averageStock(Model model) {
        model.addAttribute("double", "Average stock is " + store.getAverageStock());
        return "averagestock";
    }

    @RequestMapping(value = "/most-expensive")
    public String getMostExpensive(Model model) {
        model.addAttribute("double", "Most expensive Item is " + store.getMostExpensive());
        return "averagestock";
    }

    @RequestMapping(value = "/webshop/search")
    public String search(Model model, @RequestParam String search) {
        model.addAttribute("items", store.contains(search));
        return "webshop";
    }

    @RequestMapping(value = "/contains-nike")
    public String displayNike(Model model) {
        model.addAttribute("items", store.getItemsContainingNike());
        return "webshop";
    }
}
