import org.junit.Before;
import org.junit.Test;
import tripcalculator.fuel.FuelTypes;
import tripcalculator.vehicle.Truck;

import static org.junit.Assert.assertTrue;

public class TruckTest extends FuelTypes {

    private Truck testTruck1, testTruck2;

    @Before
    public void setup() {
        testTruck1 = new Truck(1000,"patrol",8,true,3);
        testTruck2 = new Truck(1000,"patrol",8,true,3);
    }

    @Test
    public void typeReturnsPatrol() {
        assertTrue(testTruck1.getTypeOfFuel() == FuelType.PATROL);
    }

    @Test
    public void cargoReturnCargo() {
        assertTrue(testTruck1.getCargo() == 1000);
    }

    @Test
    public void averageConsumtionReturnsAverageConsumtion() {
        assertTrue(testTruck1.getAverageConsumption() == 8);
    }

    @Test
    public void adBlueReturnsAdBlue() {
        assertTrue(testTruck1.isAdBlue());
    }

    @Test
    public void axlesReturnsAxles() {
        assertTrue(testTruck1.getAxles() == 3);
    }

    @Test
    public void truckEqualsTruck() {
        assertTrue(testTruck1.equals(testTruck2));
    }

    @Test
    public void truckSaysItsATruck() {
        assertTrue(testTruck1.whoAmI().equals("Truck"));
    }

    @Test
    public void toStringReturnsValues() {
        assertTrue(testTruck1.toString().equals("8.0;PATROL;1000;true;3"));
    }

}
