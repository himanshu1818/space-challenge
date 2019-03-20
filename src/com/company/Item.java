package com.company;
public class Item {
    private String name;
    private double weight;
    // Each Item has a name and weight.
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}