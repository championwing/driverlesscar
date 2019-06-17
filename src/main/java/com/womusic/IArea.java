package com.womusic;

/**
 * IArea describing area the car could go to
 * the area could be rectangle, triangle, or any other irregular polygon
 */
public interface IArea {
    boolean isInArea(int x, int y);
}
