package com.womusic;

/*
    Modeling position
 */
public class Position {
    private int x;
    private int y;

    public Position(int initX, int initY)
    {
        x = initX;
        y = initY;
    }

    public Position(Position pos)
    {
        x = pos.getX();
        y = pos.getY();
    }

    /*
        when an object in pos, and orientation, calculate the next pos after it move forward or backward
     */
    public void move(Orientation ori, boolean forward) {
        int dt = forward ? 1: -1;  // forward or backward
        switch (ori.getOrientation())  {
            case Orientation.EAST:  x += dt; break;
            case Orientation.WEST:  x -= dt; break;
            case Orientation.NORTH: y += dt; break;
            case Orientation.SOUTH: y -= dt; break;
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public String toString() {
        return String.format("Position(%d, %d)", x, y);
    }
}
