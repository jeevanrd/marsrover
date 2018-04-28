package commands;

import com.marsrover.MarsRover;
import com.marsrover.commands.MoveCommand;
import com.marsrover.universe.Coordinates;
import com.marsrover.universe.Direction;
import com.marsrover.universe.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class MoveCommandTest {

    @Test
    public void testThatMoveCommandMovesTheNavigableObject() {
        MoveCommand command = new MoveCommand();
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover rover = new MarsRover(plateau, Direction.N, startingPosition);
        command.execute(rover);
        Assert.assertEquals("1 3 N", rover.currentLocation());
    }

}
