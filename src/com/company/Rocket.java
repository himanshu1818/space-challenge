package com.company;
public class Rocket implements SpaceShip {
    // By default, launch() and land() methods will return true
 public boolean launch() {
     return true;
 }
 public boolean land() {
     return true;
 }  private int rocketCost;
    private double currentWeight;
    private double cargoLimit;
    // A rocket can carry more cargo only if it does not add more weight than the rocket can carry.
    @Override
    public boolean canCarry(Item item) {
        if ((currentWeight + item.getWeight()) <= this.cargoLimit) {
            System.out.println("item added to the rocket.");
            return true;
        } else {
            System.out.println("Cannot add item! Another Rocket is needed!");
            return false; }
    }
    // Each item added to a rocket increases its weight.
    @Override public void carry(Item item) {
        this.currentWeight += item.getWeight();
        System.out.println("Current rocket Weighs: " + currentWeight);
        System.out.println("item added " + item.getName());
    }
    // Getter and setter methods allow outside classes to access private variables within the Rocket class.
    //method for setting up the rocket cost
    public void setRocketCost(int rocketCost) {
        this.rocketCost = rocketCost;
    } // getter method for rocket cost
    public int getRocketCost() {
        return rocketCost;
    }
     //method for currentWeight
    public double getCurrentWeight() {
        return currentWeight;
    }
    public void setMaxCargo(double cargoLimit) {
        this.cargoLimit = cargoLimit;
    }
}
