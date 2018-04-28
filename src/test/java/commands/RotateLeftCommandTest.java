package commands;

import com.marsrover.MarsRover;
import com.marsrover.commands.RotateLeftCommand;
import com.marsrover.universe.Coordinates;
import com.marsrover.universe.Direction;
import com.marsrover.universe.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class RotateLeftCommandTest {

    @Test
    public void testThatRotateLeftCommandRotatesTheNavigableObjectLeft() {
        RotateLeftCommand command = new RotateLeftCommand();
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover rover = new MarsRover(plateau, Direction.N, startingPosition);
        command.execute(rover);
        Assert.assertEquals("1 2 W", rover.currentLocation());
    }

}
