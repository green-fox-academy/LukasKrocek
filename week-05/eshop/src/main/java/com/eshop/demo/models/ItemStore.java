package com.eshop.demo.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ItemStore {

    private List<Item> items;

    public ItemStore() {
        items = new ArrayList<>();
        items.add(new Item("Shoes", "for running", 50000, 5));
        items.add(new Item("Hat", "cover", 5300, 3));
        items.add(new Item("Shoes", "nike for running", 10000, 0));
        items.add(new Item("nike Shoes", "for running", 60000, 4));
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Item> getAvailableItems() {
        return items.stream()
                .filter(i -> i.getStock() > 0)
                .collect(Collectors.toList());
    }

    public List<Item> getItemsSortedByPrice() {
        return items.stream()
                .sorted(Comparator.comparing(Item::getPrice))
                .collect(Collectors.toList());
    }

    public List<Item> getItemsContainingNike() {
        return items.stream()
                .filter(i -> i.getName().contains("nike") || i.getDescription().contains("nike"))
                .collect(Collectors.toList());
    }

    public List<Item> contains(String search) {
        return items.stream()
                .filter(i -> i.getName().contains(search) || i.getDescription().contains(search))
                .collect(Collectors.toList());
    }

    public double getAverageStock() {
        return items.stream()
                .mapToDouble(Item::getStock)
                .average()
                .getAsDouble();
    }

    public String getMostExpensive() {
        return items.stream()
                .max(Comparator.comparing(Item::getPrice))
                .map(item -> item.getName())
                .get();
    }
}
