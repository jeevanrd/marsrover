import com.marsrover.MarsRover;
import com.marsrover.universe.Coordinates;
import com.marsrover.universe.Direction;
import com.marsrover.universe.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class MarsRoverTest {

    @Test
    public void canProvideCurrentLocationAsString() {
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(3,3);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        Assert.assertEquals("3 3 N", marsRover.currentLocation());
    }

    @Test
    public void canRotateLeft() {
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        marsRover.turnLeft();
        Assert.assertEquals("1 2 W", marsRover.currentLocation());
    }

    @Test
    public void canRotateRight() {
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        marsRover.turnRight();
        Assert.assertEquals("1 2 E", marsRover.currentLocation());
    }

    @Test
    public void canMove() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        marsRover.move();
        Assert.assertEquals("1 3 N", marsRover.currentLocation());
    }

    @Test
    public void canRunCommandToRotateRight() {
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        marsRover.run("R");
        Assert.assertEquals("1 2 E", marsRover.currentLocation());
    }

    @Test
    public void canRunCommandToRotateLeft() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        marsRover.run("L");
        Assert.assertEquals("1 2 W", marsRover.currentLocation());
    }

    @Test
    public void canRunCommandToMove() {
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        marsRover.run("M");
        Assert.assertEquals("1 3 N", marsRover.currentLocation());
    }

    @Test
    public void canRunCommandWithMultipleInstructions() {
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(3,3);
        MarsRover marsRover = new MarsRover(plateau, Direction.E, startingPosition);
        marsRover.run("MMRMMRMRRM");
        Assert.assertEquals("5 1 E", marsRover.currentLocation());
    }

    @Test
    public void wontDriveOffPlateau() {
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(3,3);
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
        marsRover.run("MMMMMMMMMMR");
        Assert.assertEquals("3 5 E", marsRover.currentLocation());
    }

}
