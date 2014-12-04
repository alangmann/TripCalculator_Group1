/**
 * Created by christoph on 11/27/2014.
 */
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SpritTest {

    private Sprit testSprit = Sprit.getInstace();

    @Test
    public void dieselGetsDiesel () {
        assertTrue(testSprit.getDiesel(Sprit.Day.MONDAY)>0);
    }

    @Test
    public void petrolGetsPetrol () {
        assertTrue(testSprit.getPetrol(Sprit.Day.MONDAY)>0);
    }
}
