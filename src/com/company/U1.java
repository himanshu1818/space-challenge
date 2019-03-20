package com.company;
public class U1 extends Rocket {
    private  double weight = 10000;// weight of rocket 10 tonnes
    private final double maxWeight = 18000;
    private double launchFailure = .05;
    private double landFailure = .01;
    private double cargoLimit=maxWeight-weight;// maximum cargo limit is max weight - rocket weight i.e 18 tonnes - 10
    // tonnes 8 tonnes
    // Whenever a new U1 is created, it is initialized weighing 10000, with a maximum capacity of 18000.
    public U1() {this(10000);}
    //constructor for U1
    public U1(double currentWeight) {
        int rocketCost = 1000000;
        setRocketCost(rocketCost);
        setMaxCargo(cargoLimit);
    }
    // Chance of launch explosion = 5% * (cargo carried / cargo limit)
    public boolean launch () {
        //random number assigned to variable launchNum from 1 to 100
           double launchNum =random();
        //if condition for launch
        if (launchNum >(launchFailure * (getCurrentWeight()/cargoLimit)*100)) {
            return true;
        } else {
            return false;
        }
    }
    // Chance of landing crash = 1% * (cargo carried / cargo limit)
    public boolean land() {
        double landNum = random();
        //if condition for land
        if (landNum > (landFailure * (getCurrentWeight() / cargoLimit)*100)) {
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