package com.womusic.impl;

import com.womusic.IArea;

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
    public boolean isInArea(int x, int y) {
        if (x>=1 && x<=length && y>=1 && y<=width)
            return true;
        return false;
    }
}
