package com.womusic.impl;

import com.womusic.IArea;
import com.womusic.Position;

/**
 * An instance of IArea, rectangle park.
 */
public class Park implements IArea {
    private int length, width;

    public Park(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public boolean isInArea(Position pos) {
        int x = pos.getX();
        int y = pos.getY();

        if (x>=1 && x<=length && y>=1 && y<=width)
            return true;
        return false;
    }
}
