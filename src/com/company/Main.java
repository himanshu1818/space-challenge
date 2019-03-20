package com.company;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int budgetU1phase1 = 0;
        int budgetU1phase2 = 0;
        int budgetU2phase1 = 0;
        int budgetU2phase2 = 0;
        File phase1File = new File("phase-1.txt");
        File phase2File = new File("phase-2.txt");
        // initiating arrayList of items and rockets
        ArrayList<Item> Items1;
        ArrayList<Item> Items2;
        ArrayList<Rocket> u1Phase1;
        ArrayList<Rocket> u1Phase2;
        ArrayList<Rocket> u2Phase1;
        ArrayList<Rocket> u2Phase2;
        // Simulation object
        Simulation simulation = new Simulation();
        //Load Items for Phase-1 and Phase-2
        Items1 = simulation.loadItems(phase1File);
        Items2 = simulation.loadItems(phase2File);
        //  Load  U1 rockets for Phase-1 and then for Phase-2
        u1Phase1 = simulation.loadU1(Items1);
        u1Phase2 = simulation.loadU1(Items2);
        u2Phase1 = simulation.loadU2(Items1);
        u2Phase2 = simulation.loadU2(Items2);
        //printing message for starting of simulation 1 of U1 rocket
        System.out.println("\n Starting Phase 1 simulation  of U1 Rockets");
        budgetU1phase1 = (simulation.runSimulation(u1Phase1));
        //displaying budget for phase1
        System.out.println("Total budget for U1 rockets for Phase 1 = " + budgetU1phase1 + "  \n");
        //starting simulation of phase 2 of U1 rocket
        System.out.println("\nStart Phase 2 simulation  of U1 Rocket");
        budgetU1phase2 = simulation.runSimulation(u1Phase2);
        System.out.println("Total budget for U1 rockets for Phase 2 = " + budgetU1phase2 + " \n");
        System.out.println("\nStart Phase 1 simulation  of U2 Rockets");
        budgetU2phase1 = simulation.runSimulation(u2Phase1);
        System.out.println("Total budget for U2 rockets for Phase 1 = " + budgetU2phase1 + " \n");
        //printing the budget and starting the simulation of rocket U2
        System.out.println("\n Start Phase 2 simulation of U2 Rockets");
        budgetU2phase2 = simulation.runSimulation(u2Phase2);
        //budget printed on screen
        System.out.println("Total budget for U2 rockets for Phase 2 = " + budgetU2phase2 + " \n");

    }
}
