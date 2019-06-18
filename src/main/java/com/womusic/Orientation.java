package com.womusic;

/*
    Modeling Orientation
 */
public class Orientation {
    /*
        Could extend orientations to 8 in next edition: NorthEast, NorthWest, SouthEast, SouthWest
     */
    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    public static final String EAST = "E";
    public static final String WEST = "W";

    private String orientation;

    public Orientation(String ori) {
        orientation = ori;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    /*
    Could extend rotation functions to: doRotation45, doRotation180, doRotation270
    */
    public void doRotation90(boolean clockwise){
        String new_dir = null ;
        switch ( orientation ){
            case NORTH : new_dir = clockwise ? EAST:WEST ; break;
            case EAST : new_dir = clockwise? SOUTH:NORTH ; break;
            case SOUTH : new_dir = clockwise? WEST:EAST ; break;
            case WEST : new_dir = clockwise? NORTH:SOUTH ; break;
        }
        orientation = new_dir ;
    }

    @Override
    public String toString(){
        return String.format("Orientation(%s)", orientation);
    }

}
