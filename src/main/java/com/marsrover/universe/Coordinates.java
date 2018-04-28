package com.marsrover.universe;

public class Coordinates {

    private int xCoord;
    private int yCoord;

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public Coordinates(final int xCoord, final int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public Coordinates newCoordinatesFor(final int xCoordStepValue, final int yCoordStepValue) {
        return new Coordinates(this.xCoord + xCoordStepValue, this.yCoord + yCoordStepValue);
    }

    @Override
    public String toString() {
        StringBuilder coordOutput = new StringBuilder();
        coordOutput.append(xCoord);
        coordOutput.append(" ");
        coordOutput.append(yCoord);
        return coordOutput.toString();
    }

    public boolean hasWithinBounds(final Coordinates coordinates) {
        return isXCoordinateWithinBounds(coordinates.xCoord) && isYCoordinateWithinBounds(coordinates.yCoord);
    }

    public boolean hasOutsideBounds(final Coordinates coordinates) {
        return isXCoordinateInOutsideBounds(coordinates.xCoord) && isYCoordinateInOutsideBounds(coordinates.yCoord);
    }

    private boolean isXCoordinateInOutsideBounds(final int xCoord) {
        return xCoord >= this.xCoord;
    }

    private boolean isYCoordinateInOutsideBounds(final int yCoord) {
        return yCoord >= this.yCoord;
    }

    private boolean isYCoordinateWithinBounds(final int yCoord) {
        return yCoord <= this.yCoord;
    }

    private boolean isXCoordinateWithinBounds(final int xCoord) {
        return xCoord <= this.xCoord;
    }

    public Coordinates newCoordinatesForStepSize(final int xCoordStepValue, final int yCoordStepValue) {
        return new Coordinates(xCoord+xCoordStepValue, yCoord+yCoordStepValue);
    }

}
