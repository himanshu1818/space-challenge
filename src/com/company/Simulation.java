package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
public class Simulation {
    //arrayList of items for loading
    ArrayList<Item> loadItems(File file) {
        ArrayList<Item> A = new ArrayList<>();
         /*try and catch logic for checking if the file exists or not and if doesn't exist then printing "file not found "
          message*/
        try {
            Scanner scanner = new Scanner(file);
            String[] elements;
            while (scanner.hasNextLine()) {
                elements = scanner.nextLine().trim().split("=");
                if (elements.length == 2) {
                    A.add(new Item(elements[0].trim(), Integer.parseInt(elements[1].trim())));
                }
            }
            scanner.close();
            return A;
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(" file not found");
            System.exit(0);//end the program if exception occurs
        }
        return null;
    }
    //arrayList of rockets in which arrayList of items is passed argument
    ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> u1Rockets = new ArrayList<>(); //An ArrayList to hold all U1 rockets needed.
        Rocket U1 = createU1();
        //looping for iterating that rocket can carry item and if yes then adding it to it
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (U1.canCarry(item)) {
                U1.carry(item);
            } else {
                u1Rockets.add(U1);
                U1= createU1();
                System.out.println("New U1 rocket created..");
                U1.carry(item);
            }
            if (!iterator.hasNext()) {//if iterator has no item
                u1Rockets.add(U1);
            }
        }
        return u1Rockets;
}
    //arrayList of rockets U2 in which arrayList of items is passed as argument
     ArrayList<Rocket> loadU2(ArrayList<Item> items) {
         ArrayList<Rocket> u2Rockets = new ArrayList<>();//An ArrayList to hold all U2 rockets needed.
         Rocket U2 = createU2();// creating a new rocket
         //looping for iterating that rocket can carry item and if yes then adding it to it
         Iterator iterator = items.iterator();
         while (iterator.hasNext()) {
             Item item = (Item) iterator.next();
             if (U2.canCarry(item)) {
                 U2.carry(item);
             } else {
                 u2Rockets.add(U2);
                 U2= createU2();
                 System.out.println("New U2 rocket created..");
                 U2.carry(item);
             }
             if (!iterator.hasNext()) {// if iterator has no item
                 u2Rockets.add(U2);
             }
         }
         return u2Rockets;// returning the value of u1rockets
     }
    //method for running the simulation and passing arrayList of rockets in it for simulation of rockets
     public int  runSimulation(ArrayList<Rocket> rockets) {
         boolean launch;
         boolean land;
         Rocket r;//creating a rocket
         boolean relaunch=false;//realunch varivale set to false initially
         int length = rockets.size();// variable equals to the value of arrayList of rockets 'rockets' size
         System.out.println(length + " rockets needed");// printing how many rockets needed
         int rocketCount=0;// counter for rocket
         int budget = 0;// budget instantiating to zero and after updating it in loop
         //for loop for rockets to be launched and land
         for (int i=0; i<length; i++) {
              r=rockets.get(i);
              launch=r.launch();//launch method returns true and false for launching
              land=r.land();//land method returns true and false for landing
             //if rockets launched
             if (launch){
                 rocketCount=rocketCount+1;//incrementing the counter by 1
                 System.out.println("Rocket "+rocketCount+" launched successfully.");
                 if (land){System.out.println("and landed  successfully.");//printing if landed
                 }
                 else{System.out.println("and crashed while landing.");//printing if both if condition didn't satisfied
                 }
             }
             else{System.out.println("Rocket "+rocketCount+" exploded while launching.");//if launch didn't succeed then print this
             }
             budget+=r.getRocketCost();//update the budget
             if(!land || !launch){ //if land or launch are false
                 relaunch=true; // set relaunch to true
                 System.out.println("Relaunching Rocket "+rocketCount);//relaunching that rocket number
             }
             //while relaunch is true
             while(relaunch){
                 Rocket r_new;// create a new rocket
                 r_new=rockets.get(i);
                 launch=r_new.launch();// get launch and assing to launch and land boolean variable
                 land=r_new.land();
                 if (launch){//if launch is true then check for land
                     rocketCount=rocketCount+1;//increment the counter
                     System.out.println("Rocket "+rocketCount+" launched successfully.");
                     if (land){// if land is true then print the message inside it
                         System.out.println("and landed  successfully.");
                     }
                     else{System.out.println("and crashed while landing..");//print crashed if land is not true
                     }
                 }
                 else{System.out.println("Rocket "+rocketCount+" exploded while Relaunching..");//else print exploded
                 }
                 budget+=r_new.getRocketCost();//again update the budget
                 if(land && launch){//if land and launch are true
                     relaunch=false;//relaunch is false
                 }else {System.out.println("Relaunching again.");//else relaunch
                 }
             }
         }
         return budget;// returning the budget
     }
     //method for creating a rocket for U1 and U2
     private Rocket createU1(){
        return new U1();
    }
    private Rocket createU2(){
        return new U2();
     }
}