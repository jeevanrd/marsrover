package parser;

import com.marsrover.parser.InputUtil;
import com.marsrover.universe.Coordinates;
import com.marsrover.universe.Direction;
import com.marsrover.universe.Plateau;
import com.marsrover.universe.RoverPosition;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class InputUtilTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void parsePlateauInput() {
        Plateau p = InputUtil.parsePlateauInput("5 5");
        Assert.assertEquals(p.getTopRightCoordinates().getxCoord(), 5);
        Assert.assertEquals(p.getTopRightCoordinates().getyCoord(), 5);
    }

    @Test(expected = NumberFormatException.class)
    public void parsePlateauInputWithError() {
        Plateau p = InputUtil.parsePlateauInput("5 E");
    }

    @Test
    public void parseRoverPositionInput() {
        RoverPosition p = InputUtil.parseRoverPositionInput("5 5 N");
        Assert.assertEquals(p.getCoordinates().getxCoord(), 5);
        Assert.assertEquals(p.getCoordinates().getyCoord(), 5);
        Assert.assertEquals(p.getDirection(), Direction.N);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void parseRoverPositionInputWithInvalidArgument() {
        InputUtil.parseRoverPositionInput("5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseRoverPositionInputWithError() {
        RoverPosition p = InputUtil.parseRoverPositionInput("5 5 U");
        Assert.assertEquals(p.getCoordinates().getxCoord(), 5);
        Assert.assertEquals(p.getCoordinates().getyCoord(), 5);
        Assert.assertEquals(p.getDirection(), Direction.N);
    }

    @Test
    public void processRover() {
        List<String> input = new ArrayList<>();
        input.add("5 5");
        input.add("1 2 N");
        input.add("LMLMLMLMM");
        input.add("3 3 E");
        input.add("MMRMMRMRRM");

        List<String> output = InputUtil.process(input);
        Assert.assertEquals(output.get(0), "1 3 N");
        Assert.assertEquals(output.get(1), "5 1 E");
    }


    @Test
    public void processRoverOuputWithZeroSize() {
        List<String> input = new ArrayList<>();
        input.add("5 E");
        input.add("1 2 N");
        input.add("LMLMLMLMM");
        input.add("3 3 E");
        input.add("MMRMMRMRRM");

        List<String> output = InputUtil.process(input);
        Assert.assertEquals(output.size(),0);
    }

    @Test
    public void processRoverWithRoverPositionError() {
        List<String> input = new ArrayList<>();
        input.add("5 5");
        input.add("1 E N");
        input.add("LMLMLMLMM");
        input.add("3 E");
        input.add("MMRMMRMRRM");

        List<String> output = InputUtil.process(input);
        Assert.assertEquals(output.get(0), "Invalid Rover position input For input string: \"E\"");
        Assert.assertEquals(output.get(1), "Invalid Rover position input For input string: \"E\"");
    }
}
