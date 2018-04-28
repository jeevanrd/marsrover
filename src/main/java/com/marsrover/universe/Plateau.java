package com.marsrover.universe;

public class Plateau {
    private Coordinates topRightCoordinates = new Coordinates(0, 0);
    private Coordinates bottomLeftCoordinates = new Coordinates(0, 0);

    public Coordinates getTopRightCoordinates() {
        return topRightCoordinates;
    }

    public Plateau(final int topRightXCoordinate, final int topRightYCoordinate) {
        this.topRightCoordinates = this.topRightCoordinates.newCoordinatesFor(topRightXCoordinate, topRightYCoordinate);
    }

    public boolean hasWithinBounds(final Coordinates coordinates) {
        return this.bottomLeftCoordinates.hasOutsideBounds(coordinates) && this.topRightCoordinates.hasWithinBounds(coordinates);
    }

}
