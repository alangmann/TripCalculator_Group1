import org.junit.Before;
import org.junit.Test;
import tripcalculator.beans.WeekdayFormatException;
import tripcalculator.bl.Calculator;
import tripcalculator.route.Route;
import tripcalculator.vehicle.Car;
import tripcalculator.vehicle.Truck;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Locale;

import static org.junit.Assert.assertTrue;

public class CalculatorTest {

    private Calculator tripCalculator;

    @Before
    public void setup() throws Exception {
        tripCalculator = Calculator.getInstance();
    }

    @Test
    public void loadRoutesWorks() throws IOException, WeekdayFormatException {
        assertTrue(Calculator.getInstance().getRoutes().size() > 0);
    }

    @Test
    public void CO2ConsumptionFor10kmAnd5mSlopeReturns1comma325() {
        assertTrue(String.format(Locale.US, "%.3f", (tripCalculator.calculateCo2Consumption(new Route(1, 10, 5, "test", 1), null))).equals("1.326"));
    }

    @Test
    public void CO2ConsumptionFor20kmAnd5mSlopeReturns2comma640() {
        assertTrue(String.format(Locale.US, "%.3f", (tripCalculator.calculateCo2Consumption(new Route(1, 20, 5, "test", 1), null))).equals("2.651"));
    }

    @Test
    public void CO2ConsumptionFor25kmAnd88mSlopeReturns3comma324() {
        assertTrue(String.format(Locale.US, "%.3f", (tripCalculator.calculateCo2Consumption(new Route(1, 25, 88, "test", 1), null))).equals("3.324"));
    }

    @Test
    public void CO2ConsumptionFor1kmAnd50mSlopeReturns0() {
        assertTrue(tripCalculator.calculateCo2Consumption(new Route(1, 1, -50, "test", 1), null) == 0);
    }

    @Test
    public void GravelroadIsDoubleHighway() {
        assertTrue(tripCalculator.calculateCo2Consumption(new Route(1, 1, -50, "Highway", 1), null) * 2 == tripCalculator.calculateCo2Consumption(new Route(1, 1, -50, "Gravelroad", 1), null));
    }

    @Test
    public void exampleCarCalculationReturns1comma458() {
        assertTrue(String.format(Locale.US, "%.3f", (tripCalculator.calculateCo2Consumption(new Route(1, 10, 0, "test", 0), new Car(100, "test", 5)))).equals("1.458"));
    }

    @Test
    public void exampleTruckCalculationReturns1comma458() {
        assertTrue(String.format(Locale.US, "%.3f", (tripCalculator.calculateCo2Consumption(new Route(1, 10, 0, "test", 0), new Truck(1000, "test", 5, false, 3)))).equals("1.458"));
    }

    @Test
    public void exampleTruckCalculationWithListReturns1comma458() {
        LinkedList<Route> routes = new LinkedList<>();
        routes.add(new Route(1, 10, 0, "test", 0));
        assertTrue(String.format(Locale.US, "%.3f", (tripCalculator.calculateAllCo2(routes, new Truck(1000, "test", 5, false, 3)))).equals("1.458"));
    }

    @Test
    public void idGetsRoute() {
        assertTrue(tripCalculator.getRouteById(1).getRouteID() == 1);
    }

    @Test
    public void highIdGetsNullRoute() {
        assertTrue(tripCalculator.getRouteById(99) == null);
    }

    @Test
    public void exampleCostCalculationReturns34comma73() throws WeekdayFormatException {
        assertTrue(String.format(Locale.US, "%.2f", (tripCalculator.calculateTotalCostOfRoute(new Route(1, 10, 500, "test", 5), new Truck(20000, "diesel", 35, true, 4), "monday"))).equals("34.73"));
    }

    @Test
    public void exampleCostCalculationWithListReturns34comma73() throws WeekdayFormatException {
        LinkedList<Route> routes = new LinkedList<>();
        routes.add(new Route(1, 10, 500, "test", 5));
        assertTrue(String.format(Locale.US, "%.2f", (tripCalculator.calculateAllCost(routes, new Truck(20000, "diesel", 35, true, 4), "monday"))).equals("34.73"));
    }

    @Test
    public void anotherExampleCostCalculationReturns39comma45() throws WeekdayFormatException {
        assertTrue(String.format(Locale.US, "%.2f", (tripCalculator.calculateTotalCostOfRoute(new Route(1, 10, 500, "test", 5), new Truck(20000, "petrol", 35, true, 4), "monday"))).equals("39.45"));
    }

    @Test
    public void exampleCostCalculationWithNegSlopeReturns0() throws WeekdayFormatException {
        assertTrue(tripCalculator.calculateTotalCostOfRoute(new Route(1, 10, -50000, "test", 5), new Truck(20000, "diesel", 35, true, 4), "monday") == 0);
    }
}