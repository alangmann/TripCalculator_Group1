import org.junit.Before;
import org.junit.Test;
import tripcalculator.fuel.FuelTypes;
import tripcalculator.vehicle.Car;

import static org.junit.Assert.assertTrue;

public class CarTest extends FuelTypes {

    private Car testCar, testCar2;

    @Before
    public void setup() {
        testCar = new Car(1, "patrol", 5);
        testCar2 = new Car(1, "patrol", 5);
    }

    @Test
    public void typeReturnsPatrol() {
        assertTrue(testCar.getTypeOfFuel() == FuelType.PATROL);
    }

    @Test
    public void cargoReturnCargo() {
        assertTrue(testCar.getCargo() == 1);
    }

    @Test
    public void averageConsumptionReturnsAverageConsumption() {
        assertTrue(testCar.getAverageConsumption() == 5);
    }

    @Test
    public void carEqualsCar() {
        assertTrue(testCar.equals(testCar2));
    }
}
