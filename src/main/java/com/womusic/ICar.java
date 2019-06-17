package com.womusic;

/**
 * @author wuyongtao
 *
 * driverless car function:
 * 1.moving forward into different directions
 * 2.turning clockwise in a car park
 * 3.remenber its position
 * 4.remenber its orientation
 */

public interface ICar {
    /**
     * move forward into different directions
     * @param command
     */
    void doCommand(String command) throws Exception ;  //accept all action commands the car will do

    int getPositionX();
    int getPositionY();
    String getOrientation();

    String version();   // do version control to extend commands supported
    String supportedCommands(); //user can get all supported commands in this version
}
