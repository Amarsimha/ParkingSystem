package com.whiteclark.cli;

import java.io.Console;

import com.whiteclark.parking.CarParkingSystem;
import com.whiteclark.parking.systems.AutomaticParkingSystem;

public class Main {

    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        CarParkingSystem carParkingSystem = (CarParkingSystem) new AutomaticParkingSystem(15, 15);

        System.out.println("White Clark Parking System");
        System.out.println("Enter a command, Input Format should be:");
        System.out.println("X,Y:[RLF]+ OR EXIT");

        boolean keepRunning = true;
        while (keepRunning) {
            String inputString = console.readLine("");
            if ("EXIT".equalsIgnoreCase(inputString)) {
                keepRunning = false;
            } else {
                try {
                    String outputVal = carParkingSystem.executeCommand(inputString);
                    System.out.println(outputVal);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}