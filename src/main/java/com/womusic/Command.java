package com.womusic;

/**
 * @author wuyongtao
 * define Command for car
 */
public class Command {
    public static final String VERSION = "1.0";

    public static final String FORWARD = "F";
    public static final String BACKWARD = "B";
    public static final String TURN90RIGHT = "90R";
    public static final String TURN90LEFT = "90L";
    /*
    can extend commands to version 2.0 as following:
        turn 45 left, turn 45 right, tun 180 left, turn 180 right , turn 270 left, turn 270 right
        and extend directions to 8

    can extend commands to version 3.0 as following:
        forward two steps: 2F,  backward 3 steps, 3B, forward, backward N steps
     */
}
