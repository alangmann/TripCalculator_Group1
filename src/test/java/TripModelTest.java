import org.junit.Before;
import org.junit.Test;
import tripcalculator.beans.Trip;
import tripcalculator.beans.WeekdayFormatException;
import tripcalculator.bl.TripModel;
import tripcalculator.route.Route;
import tripcalculator.vehicle.Car;
import tripcalculator.vehicle.Truck;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class TripModelTest {

    private TripModel testTripModel;
    private Trip testTrip1;
    private Trip testTrip2;
    private Trip testTrip3;
    private LinkedList<Route> testRoute;
    private Car testCar;
    private Car testCar2;
    private Truck testTruck;

    @Before
    public void setUp() {
        testTripModel = new TripModel();
        testRoute.add(new Route(1, 10, 5, "Highway", 5));
        testCar = new Car(100, "diesel", 5);
        testCar2 = new Car(200, "diesel", 6);
        testTruck = new Truck(1000, "diesel", 5, true, 3);
        testTrip1 = new Trip(testRoute, testCar);
        testTrip2 = new Trip(testRoute, testTruck);
        testTrip3 = new Trip(testRoute, testCar2);
        testTripModel.addTrip(testTrip1);
        testTripModel.addTrip(testTrip2);
    }

    @Test
    public void testAddTrip() {
        assertTrue(testTripModel.getTrips().contains(testTrip1));
    }

    @Test
    public void testGetRowCount() {
        assertTrue(testTripModel.getRowCount() == 2);
    }

    @Test
    public void testGetColumnCount() {
        assertTrue(testTripModel.getHeadings().length == testTripModel.getColumnCount());
    }

    @Test
    public void testGetValueAtKm() {
        assertTrue(testTripModel.getValueAt(0, 0).toString().equals("10.0"));
    }

    @Test
    public void testGetValueAtSlope() {
        assertTrue(testTripModel.getValueAt(0, 1).toString().equals("5.0"));
    }

    @Test
    public void testGetValueAtType() {
        assertTrue(testTripModel.getValueAt(0, 2).toString().equals("HIGHWAY"));
    }

    @Test
    public void testGetValueAtFee() {
        assertTrue(testTripModel.getValueAt(0, 3).toString().equals("5.0"));
    }

    @Test
    public void testGetValueAtWhoAmI() {
        assertTrue(testTripModel.getValueAt(0, 4).toString().equals("Car"));
    }

    @Test
    public void testGetValueAtTypeOfFuel() {
        assertTrue(testTripModel.getValueAt(0, 5).toString().equals("DIESEL"));
    }

    @Test
    public void testGetValueAtAvgConsumtion() {
        assertTrue(testTripModel.getValueAt(0, 6).toString().equals("5.0"));
    }

    @Test
    public void testGetValueAtCargo() {
        assertTrue(testTripModel.getValueAt(0, 7).toString().equals("100"));
    }

    @Test
    public void testCarPlaceholderGetValueAtAdBlue() {
        assertTrue(testTripModel.getValueAt(0, 8).toString().equals(" - "));
    }

    @Test
    public void testTruckGetValueAtAdBlue() {
        assertTrue(testTripModel.getValueAt(1, 8).toString().equals("Yes"));
    }

    @Test
    public void testCarPlaceholderGetValueAtAxles() {
        assertTrue(testTripModel.getValueAt(0, 9).toString().equals(" - "));
    }

    @Test
    public void testTruckGetValueAtAxles() {
        assertTrue(testTripModel.getValueAt(1, 9).toString().equals("3"));
    }

    @Test
    public void testCarErrorGetValueAtWrongIndex() {
        assertTrue(testTripModel.getValueAt(0, 1000).toString().equals("error"));
    }

    @Test
    public void testTruckErrorGetValueAtWrongIndex() {
        assertTrue(testTripModel.getValueAt(1, 1000).toString().equals("error"));
    }

    @Test
    public void testGetColumnName() {
        assertTrue(testTripModel.getHeadings()[0].equals(testTripModel.getColumnName(0)));
    }

    @Test
    public void testSaveLoadData() throws IOException, WeekdayFormatException {
        testTripModel.saveData();
        testTripModel.addTrip(testTrip3);
        try {
            testTripModel.loadData(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(testTripModel.getRowCount() == 2);
    }

    @Test
    public void testSaveLoadDataWithPaths() throws IOException, WeekdayFormatException {
        testTripModel.saveData(new File("test.csv"));
        testTripModel.addTrip(testTrip3);
        try {
            testTripModel.loadData(new File("test.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(testTripModel.getRowCount() == 2);
    }
}