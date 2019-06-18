package com.womusic;

import com.womusic.*;
import com.womusic.impl.*;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest extends TestCase {

    /*
        Given the Car is in position X = 1 and Y = 1 and facing North, when the Car turns clockwise,
        then the Car is still in the same position but is now facing East
     */
    @Test
    public void testTurnClockwise() {
        Park park = new Park(4, 4);  //set park area:rectangle 4X4
        DriverLessCar car = new DriverLessCar(1, 1, Orientation.NORTH, park);

        try {
            car.doCommand(Command.TURN90RIGHT);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Don't expect exception");
        }

        assertTrue( car.getPositionX() == 1 );
        assertTrue( car.getPositionY() == 1 );
        assertEquals(car.getOrientation(), Orientation.EAST);
    }

    /*
        Given the Car is in position X = 1 and Y = 1 and facing North, when the Car moves forward,
        then the Car is still facing North but is now in position X = 1 and Y = 2
     */
    @Test
    public void testNorthMoveForward() {
        Park park = new Park(4, 4);  //set park area:rectangle 4X4
        DriverLessCar car = new DriverLessCar(1, 1, Orientation.NORTH, park);

        try {
            car.doCommand(Command.FORWARD);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Don't expect exception");
        }

        assertTrue( car.getPositionX() == 1 );
        assertTrue( car.getPositionY() == 2 );
        assertEquals(car.getOrientation(), Orientation.NORTH);
    }

    /*
       Given the Car is in position X = 1 and Y = 1 and facing East, when the Car moves forward,
       then the Car is still facing East but is now in position X = 2 and Y = 1
    */
    @Test
    public void testEastMoveForward() {
        Park park = new Park(4, 4);  //set park area:rectangle 4X4
        DriverLessCar car = new DriverLessCar(1, 1, Orientation.EAST, park);

        try {
            car.doCommand(Command.FORWARD);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Don't expect exception");
        }

        assertTrue( car.getPositionX() == 2 );
        assertTrue( car.getPositionY() == 1 );
        assertEquals(car.getOrientation(), Orientation.EAST);
    }

    /*
       Given the Car is in position X = 1 and Y = 1 and facing West, when the Car moves forward,
       then an exception is thrown
    */
    @Test
    public void testWestMoveForwardAndOutOfBound() {
        Park park = new Park(4, 4);  //set park area:rectangle 4X4
        DriverLessCar car = new DriverLessCar(1, 1, Orientation.WEST, park);

        try {
            car.doCommand(Command.FORWARD);
            fail("Expect exception to occur, but fail");
        } catch (Exception ex) {
            assertTrue(ex instanceof CarOutOfBoundException);
            System.out.println(ex.getMessage());
        }

        assertTrue( car.getPositionX() == 1 );
        assertTrue( car.getPositionY() == 1 );
        assertEquals(car.getOrientation(), Orientation.WEST);
    }

    /*
       Given the Car is in position X = 1 and Y = 1 and facing East, when the Car moves forward twice,
       then the Car is still facing East but is now in position X = 3 and Y = 1
    */
    @Test
    public void testEastMoveForwardTwoSteps() {
        Park park = new Park(4, 4);  //set park area:rectangle 4X4
        DriverLessCar car = new DriverLessCar(1, 1, Orientation.EAST, park);

        try {
            car.doCommand(Command.FORWARD);
            car.doCommand(Command.FORWARD);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Don't expect exception");
        }

        assertTrue( car.getPositionX() == 3 );
        assertTrue( car.getPositionY() == 1 );
        assertEquals(car.getOrientation(), Orientation.EAST);
    }

    /*
       Given the Car is in position X = 2 and Y = 2 and facing North, when the Car moves forward twice,
       turn anti-clockwise, move backword, turn anti-clockwise, move forward twice
       then the Car is facing South and in position X = 3 and Y = 2
    */
    @Test
    public void testSenarios1() {
        Park park = new Park(4, 4);  //set park area:rectangle 4X4
        DriverLessCar car = new DriverLessCar(2, 2, Orientation.NORTH, park);

        try {
            car.doCommand(Command.FORWARD);
            car.doCommand(Command.FORWARD);
            car.doCommand(Command.TURN90LEFT);
            car.doCommand(Command.BACKWARD);
            car.doCommand(Command.TURN90LEFT);
            car.doCommand(Command.FORWARD);
            car.doCommand(Command.FORWARD);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Don't expect exception");
        }

        assertTrue( car.getPositionX() == 3 );
        assertTrue( car.getPositionY() == 2 );
        assertEquals(car.getOrientation(), Orientation.SOUTH);
    }

    /*
       Given the Car is in position X = 1 and Y = 1 and facing East, when the Car turns anti-clockwise for 3 times
       then the Car is facing South and still in position X = 1 and Y = 1
    */
    @Test
    public void testSenarios2() {
        Park park = new Park(4, 4);  //set park area:rectangle 4X4
        DriverLessCar car = new DriverLessCar(1, 1, Orientation.EAST, park);

        try {
            car.doCommand(Command.TURN90LEFT);
            car.doCommand(Command.TURN90LEFT);
            car.doCommand(Command.TURN90LEFT);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Don't expect exception");
        }

        assertTrue( car.getPositionX() == 1 );
        assertTrue( car.getPositionY() == 1 );
        assertEquals(car.getOrientation(), Orientation.SOUTH);
    }
}
