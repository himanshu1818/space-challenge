package com.company;
public class U2 extends Rocket {
    private double weight = 18000;//weight of rocket in 18 tonnes
    private final double maxWeight = 29000;
    private double launchFailure = .04;
    private double landFailure = .08;
    private double cargoLimit=maxWeight-weight;// maximum cargo limit is max weight - rocket weight i.e 29 tonnes - 18
    // tonnes 11 tonnes
    // Each new U2 is initialized weighing 18000, with a maximum capacity of 29000.
    public U2() {this(18000);
    }
    //constructor for U2
    public U2(double currentWeight) {
        int rocketCost = 1200000;
        setRocketCost(rocketCost);
        setMaxCargo(cargoLimit);
    }
    // Chance of launch explosion = 4% * (cargo carried / cargo limit)
    public boolean launch() {
        double launchNum = random();
        //condition for checking the launch
        if (launchNum > (launchFailure * (getCurrentWeight()/cargoLimit)*100)) {
            return true;
        } else {
            return false;
        }
    }
    // Chance of landing crash = 8% * (cargo carried / cargo limit)
    public boolean land() {
        double landNum =random();
        //condition for checking the land
        if (landNum > (landFailure * (getCurrentWeight()/cargoLimit)*100)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * @return a random number between 1 & 100
     */
    private int random() {
        return (int) (Math.random() * 100) + 1;
    }
}