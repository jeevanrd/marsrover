package universe;

import com.marsrover.universe.Coordinates;
import com.marsrover.universe.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class PlateauTest {

    @Test
    public void locationWithCoordinateWithinBoundsIsIdentified() {
        Plateau mars = new Plateau(5,5);
        Coordinates plateauCoordinates = new Coordinates(5, 0);
        Assert.assertTrue(mars.hasWithinBounds(plateauCoordinates));
    }

    @Test
    public void locationWithPositiveXCoordinateOutsideBoundsIsIdentified() {
        Plateau mars = new Plateau(5,5);
        Coordinates coordinates = new Coordinates(6, 0);
        Assert.assertFalse(mars.hasWithinBounds(coordinates));
    }

    @Test
    public void locationWithNegativeXCoordinateOutsideBoundsIsIdentified() {
        Plateau mars = new Plateau(5,5);
        Coordinates coordinates = new Coordinates(-1, 0);
        Assert.assertFalse(mars.hasWithinBounds(coordinates));
    }

    @Test
    public void locationWithPositiveYCoordinateOutsideBoundsIsIdentified() {
        Plateau mars = new Plateau(5,5);
        Coordinates coordinates = new Coordinates(0, 6);
        Assert.assertFalse(mars.hasWithinBounds(coordinates));
    }

    @Test
    public void locationWithNegativeYCoordinateOutsideBoundsIsIdentified() {
        Plateau mars = new Plateau(5,5);
        Coordinates coordinates = new Coordinates(0, -1);
        Assert.assertFalse(mars.hasWithinBounds(coordinates));
    }
}
