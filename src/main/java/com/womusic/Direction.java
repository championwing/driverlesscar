package com.womusic;

public class Direction {
    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    public static final String EAST = "E";
    public static final String WEST = "W";
    /*
    could extend directions to 8: NorthEast, NorthWest, SouthEast, SouthWest
     */

    public static String get90Rotation(String dir, boolean isTurnRight){
        String new_dir = null ;
        switch ( dir ){
            case NORTH : new_dir = isTurnRight ? EAST:WEST ; break;
            case EAST : new_dir = isTurnRight? SOUTH:NORTH ; break;
            case SOUTH : new_dir = isTurnRight? WEST:EAST ; break;
            case WEST : new_dir = isTurnRight? NORTH:SOUTH ; break;
        }
        return new_dir ;
    }

}
