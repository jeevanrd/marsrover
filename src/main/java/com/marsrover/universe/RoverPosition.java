package com.marsrover.universe;


public class RoverPosition {
    private Coordinates coordinates;
    private Direction direction;

    public RoverPosition(Coordinates coordinates, Direction direction){
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Direction getDirection() {
        return direction;
    }
}
