import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TruckTest extends FuelTypes{

    private Truck testTruck;

    @Before
    public void setup() {
        testTruck = new Truck(1,"patrol",8,true,3);
    }

    @Test
    public void typeReturnsPatrol() {
        assertTrue(testTruck.getTypeOfFuel() == FuelType.PATROL);
    }

    @Test
    public void cargoReturnCargo() {
        assertTrue(testTruck.getCargo() == 1);
    }

    @Test
    public void averageConsumtionReturnsAverageConsumtion() {
        assertTrue(testTruck.getAverageConsumption() == 8);
    }

    @Test
    public void adBlueReturnsAdBlue() {
        assertTrue(testTruck.isAdBlue());
    }

    @Test
    public void axlesReturnsAxles() {
        assertTrue(testTruck.getAxles() == 3);
    }
}
