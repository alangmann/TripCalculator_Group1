import org.junit.Before;
import org.junit.Test;
import tripcalculator.fuel.FuelTypes;
import tripcalculator.vehicle.Vehicle;

import static org.junit.Assert.assertTrue;

public class VehicleTest extends FuelTypes {

    private Vehicle testVehicle;

    @Before
    public void setup() {
        testVehicle = new Vehicle(1,"patrol",5);
    }

    @Test
    public void typeReturnsPatrol() {
        assertTrue(testVehicle.getTypeOfFuel() == FuelType.PATROL);
    }

    @Test
    public void cargoReturnCargo() {
        assertTrue(testVehicle.getCargo() == 1);
    }

    @Test
    public void averageConsumtionReturnsAverageConsumtion() {
        assertTrue(testVehicle.getAverageConsumption() == 5);
    }

}
