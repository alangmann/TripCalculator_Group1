import org.junit.Before;
import org.junit.Test;
import tripcalculator.fuel.FuelTypes;
import tripcalculator.vehicle.Vehicle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VehicleTest extends FuelTypes {

    private Vehicle testVehicle1, testVehicle2;

    @Before
    public void setup() {
        testVehicle1 = new Vehicle(1,"patrol",5);
        testVehicle2 = new Vehicle(1,"diesel",5);
    }

    @Test
    public void typeReturnsPatrol() {
        assertTrue(testVehicle1.getTypeOfFuel() == FuelType.PATROL);
    }

    @Test
    public void cargoReturnCargo() {
        assertTrue(testVehicle1.getCargo() == 1);
    }

    @Test
    public void averageConsumtionReturnsAverageConsumtion() {
        assertTrue(testVehicle1.getAverageConsumption() == 5);
    }

    @Test
    public void vehicle1DoesntEqualOtherVehicle2 () {
        assertFalse(testVehicle1.equals(testVehicle2));
    }

    @Test
    public void vehicleSaysItsAVehicle () {
        assertTrue(testVehicle1.whoAmI().equals("Vehicle"));
    }

    @Test
    public void toStringReturnsValues () {
        assertTrue(testVehicle1.toString().equals("5.0;PATROL;1"));
    }
}
