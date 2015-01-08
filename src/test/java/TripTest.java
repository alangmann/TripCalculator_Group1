import org.junit.Before;
import org.junit.Test;
import tripcalculator.beans.Trip;
import tripcalculator.route.Route;
import tripcalculator.vehicle.Car;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class TripTest {

    private Trip testTrip;
    private LinkedList<Route> testRoute;
    private Car testCar;

    @Before
    public void setUp() throws Exception {
        testRoute.add(new Route(1, 10, 5, "Highway", 5));
        testCar = new Car(100, "diesel", 5);
        testTrip = new Trip(testRoute, testCar);
    }

    @Test
    public void testGetVehicle() {
        assertTrue(testTrip.getVehicle().equals(testCar));
    }

    @Test
    public void testGetRoute() {
        assertTrue(testTrip.getRoutes().equals(testRoute));
    }

    @Test
    public void testEquals() {
        assertTrue(testTrip.equals(new Trip(testRoute, testCar)));
    }

    @Test
    public void testToString() throws Exception {
        assertTrue(testTrip.toString().equals(testRoute.toString() + ";" + testCar.toString()));
    }
}