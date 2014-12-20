import org.junit.Before;
import org.junit.Test;
import tripcalculator.fuel.FuelTypes;
import tripcalculator.vehicle.Car;

import static org.junit.Assert.assertTrue;

public class CarTest extends FuelTypes {

    private Car testCar;

    @Before
    public void setup() {
        testCar = new Car(1,"patrol",5);
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
    public void averageConsumtionReturnsAverageConsumtion() {
        assertTrue(testCar.getAverageConsumption() == 5);
    }

}
