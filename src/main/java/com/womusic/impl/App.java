package com.womusic.impl;

import com.womusic.*;

/**
 * Main function to run the car
 */
public class App {
    public static void main(String[] args) {
        Park park = new Park(4,4);  //set park area:rectangle 4X4
        DriverLessCar car = new DriverLessCar(1,1, Orientation.NORTH, park);

        System.out.println("Before commands, car status:"+ car);
        try {
            car.doCommand(Command.FORWARD);
            car.doCommand(Command.TURN90RIGHT);
            car.doCommand(Command.FORWARD);
            car.doCommand(Command.FORWARD);
            car.doCommand(Command.TURN90LEFT);
            car.doCommand(Command.BACKWARD);
        } catch (Exception ex ) {
            System.out.println(ex.getMessage());
        }
        System.out.println("After commands, car status:"+ car);
    }

}
