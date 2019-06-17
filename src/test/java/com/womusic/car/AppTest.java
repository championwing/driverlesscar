package com.womusic.car;

import com.womusic.*;
import com.womusic.impl.*;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest extends TestCase {

    @Test
    public void testCarInBound() {
        Park park = new Park(4, 5);  //set park area:rectangle 4X5
        DriverLessCar car = new DriverLessCar(1, 1, Direction.NORTH, park);
        boolean exception = false;

        try {
            car.doCommand(Command.FORWARD);
            car.doCommand(Command.TURN90RIGHT);
            car.doCommand(Command.FORWARD);
            car.doCommand(Command.TURN90RIGHT);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            exception = true;
        }

        assertTrue( car.getPositionX() == 2 );
        assertTrue( car.getPositionY() == 2 );
        assertEquals(car.getOrientation(), Direction.SOUTH);
        assertEquals(exception, false);
    }

    @Test
    public void testCarOutOfBound() {
        Park park = new Park(2, 2);  //set park area:rectangle 2X2
        DriverLessCar car = new DriverLessCar(1, 1, Direction.EAST, park);
        boolean exception = false;

        try {
            car.doCommand(Command.FORWARD);
            car.doCommand(Command.FORWARD);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            exception = true;
        }

        assertTrue( car.getPositionX() == 2 );
        assertTrue( car.getPositionY() == 1 );
        assertEquals(car.getOrientation(), Direction.EAST);
        assertEquals(exception, true);
    }
}
