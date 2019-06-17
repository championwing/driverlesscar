package com.womusic.impl;

import com.womusic.*;

/**
 * @author wuyongtao
 */
public class DriverLessCar implements ICar {

    private int x ;
    private int y ;
    private String orientation ;
    private IArea area ;

    public DriverLessCar(int x, int y, String orientation, IArea area){
        this.x = x ;
        this.y = y ;
        this.orientation = orientation ;
        this.area = area;
    }

    @Override
    public void doCommand(String cmd) throws Exception{
        String ori = orientation ;
        //move
        if (cmd.equals(Command.FORWARD) || cmd.equals(Command.BACKWARD)) {
            int destX = x ;
            int destY = y ;
            int offset = cmd.equals(Command.FORWARD)? 1:-1;

            switch (ori) {
                case Direction.NORTH: destY += offset; break;
                case Direction.SOUTH: destY -= offset; break;
                case Direction.EAST:  destX += offset; break;
                case Direction.WEST:  destX -= offset; break;
            }

            if( !area.isInArea(destX , destY) ) {
                throw new CarOutOfBoundException( String.format("Out of Bound:CarStatus:%s with command:%s}", this.toString(), cmd)  ) ;
            }
            x = destX;
            y = destY;
        } else if (cmd.equals(Command.TURN90LEFT) || cmd.equals(Command.TURN90RIGHT)) {  //rotation
            orientation = Direction.get90Rotation(ori, cmd.equals(Command.TURN90RIGHT));
        }
    }

    @Override
    public String version() { return Command.VERSION; }

    @Override
    public String supportedCommands() {
        return Command.FORWARD + "," + Command.BACKWARD + "," + Command.TURN90LEFT + "," + Command.TURN90RIGHT;
    }

    @Override
    public int getPositionX() {
        return x ;
    }

    @Override
    public int getPositionY() {
        return y ;
    }

    @Override
    public String getOrientation() {
        return orientation ;
    }

    public void setPositionX(int x) {
        this.x = x;
    }
    public void setPositionY(int y) {
        this.y = y;
    }
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
    public void setArea(IArea area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return String.format("{x: %d, y: %d, orientation: %s}" , x, y, orientation) ;
    }
}
