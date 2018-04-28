package universe;

import com.marsrover.universe.Direction;
import org.junit.Assert;
import org.junit.Test;

public class DirectionTest {

    @Test
    public void westIsOnLeftOfNorth() {
        Direction north = Direction.N;
        Direction west = north.left();
        Assert.assertEquals(Direction.W, west);
    }

    @Test
    public void eastIsOnRightOfNorth() {
        Direction north = Direction.N;
        Direction east = north.right();
        Assert.assertEquals(Direction.E, east);
    }

    @Test
    public void northIsOnRightOfWest() {
        Direction west = Direction.W;
        Direction north = west.right();
        Assert.assertEquals(Direction.N, north);
    }

    @Test
    public void southIsOnLeftOfWest() {
        Direction west = Direction.W;
        Direction south = west.left();
        Assert.assertEquals(Direction.S, south);
    }

    @Test
    public void eastIsOnLeftOfSouth() {
        Direction south = Direction.S;
        Direction east = south.left();
        Assert.assertEquals(Direction.E, east);
    }

    @Test
    public void westIsOnRightOfSouth() {
        Direction south = Direction.S;
        Direction west = south.right();
        Assert.assertEquals(Direction.W, west);
    }

    @Test
    public void northIsOnLeftOfEast() {
        Direction east = Direction.E;
        Direction north = east.left();
        Assert.assertEquals(Direction.N, north);
    }

    @Test
    public void southIsOnRightOfEast() {
        Direction east = Direction.E;
        Direction south = east.right();
        Assert.assertEquals(Direction.S, south);
    }

    @Test
    public void eastIsOneStepForwardOnXAxis() {
        Direction east = Direction.E;
        int stepSize = east.stepSizeForXAxis();
        Assert.assertEquals(1, stepSize);
    }

    @Test
    public void eastIsStationaryOnYAxis() {
        Direction east = Direction.E;
        int stepSize = east.stepSizeForYAxis();
        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void westIsOneStepBackOnXAxis() {
        Direction west = Direction.W;
        int stepSize = west.stepSizeForXAxis();
        Assert.assertEquals(-1, stepSize);
    }


    @Test
    public void westIsStationaryOnYAxis() {
        Direction west = Direction.W;
        int stepSize = west.stepSizeForYAxis();
        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void northIsOneStepForwardOnYAxis() {
        Direction north = Direction.N;
        int stepSize = north.stepSizeForYAxis();
        Assert.assertEquals(1, stepSize);
    }


    @Test
    public void northIsStationaryOnXAxis() {
        Direction north = Direction.N;
        int stepSize = north.stepSizeForXAxis();
        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void southIsOneStepBackOnYAxis() {
        Direction south = Direction.S;
        int stepSize = south.stepSizeForYAxis();
        Assert.assertEquals(-1, stepSize);
    }

    @Test
    public void southIsStationaryOnXAxis() {
        Direction south = Direction.S;
        int stepSize = south.stepSizeForXAxis();
        Assert.assertEquals(0, stepSize);
    }
}
