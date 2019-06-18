package com.womusic.impl;

import com.womusic.*;

/**
 * @author wuyongtao
 */
public class DriverLessCar implements ICar {

    private Position pos;
    private Orientation ori ;
    private IArea area ;
    public static final String VERSION = "1.0"; // car version 1.0, can be extended

    public DriverLessCar(int x, int y, String orientation, IArea area){
        pos = new Position(x, y) ;
        ori = new Orientation(orientation) ;
        this.area = area;
    }

    @Override
    public void doCommand(String cmd) throws Exception{

        //move command
        if (cmd.equals(Command.FORWARD) || cmd.equals(Command.BACKWARD)) {
            Position posBak = new Position(pos);
            pos.move(ori, cmd.equals(Command.FORWARD));

            if( !area.isInArea(pos) ) {
                pos = posBak; //restore the pos
                throw new CarOutOfBoundException( String.format("Out of Bound: Car Status:%s with Command:%s}", this.toString(), cmd)  ) ;
            }
        } else if (cmd.equals(Command.TURN90LEFT) || cmd.equals(Command.TURN90RIGHT)) {  //rotation
            ori.doRotation90(cmd.equals(Command.TURN90RIGHT));
        }
    }

    @Override
    public String version() { return VERSION; }

    @Override
    public String supportedCommands() {
        return Command.FORWARD + "," + Command.BACKWARD + "," + Command.TURN90LEFT + "," + Command.TURN90RIGHT;
    }

    @Override
    public int getPositionX() { return pos.getX(); }

    @Override
    public int getPositionY() { return pos.getY(); }

    @Override
    public String getOrientation() { return ori.getOrientation(); }

    @Override
    public String toString() {
        return String.format("{%s, %s}" , pos, ori) ;
    }
}
