import org.junit.Before;
import org.junit.Test;
import tripcalculator.fuel.Fuel;

import static org.junit.Assert.assertTrue;

public class FuelTest {

    private Fuel testFuel;

    @Before
    public void setUp() {
        testFuel = Fuel.getInstance();
    }

    @Test
    public void dieselGetsDiesel () {
        assertTrue(testFuel.getDiesel(Fuel.Day.MONDAY) > 0);
    }

    @Test
    public void petrolGetsPetrol () {
        assertTrue(testFuel.getPetrol(Fuel.Day.MONDAY) > 0);
    }
}
