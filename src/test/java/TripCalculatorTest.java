import org.junit.Before;
import org.junit.Test;
import tripcalculator.bl.TripCalculator;
import tripcalculator.route.Route;
import tripcalculator.vehicle.Car;
import tripcalculator.vehicle.Truck;

import java.util.Locale;

import static org.junit.Assert.assertTrue;

public class TripCalculatorTest {

    private TripCalculator tripCalculator;

    @Before
    public void setup() throws Exception {
        tripCalculator = TripCalculator.getInstance();
    }

    @Test
    public void loadRoutesWorks() throws Exception {
        assertTrue(TripCalculator.getInstance().getRoutes().size() > 0);
    }

    @Test
    public void CO2ConsumptionFor10kmAnd5mSlopeReturns1comma325() {
        assertTrue(String.format(Locale.US, "%.3f", (tripCalculator.calculateCo2Consumption(new Route(10, 5, "test", 1), null))).equals("1.326"));
    }

    @Test
    public void CO2ConsumptionFor20kmAnd5mSlopeReturns2comma640() {
        assertTrue(String.format(Locale.US, "%.3f", (tripCalculator.calculateCo2Consumption(new Route(20, 5, "test", 1), null))).equals("2.651"));
    }

    @Test
    public void CO2ConsumptionFor25kmAnd88mSlopeReturns3comma324() {
        assertTrue(String.format(Locale.US, "%.3f", (tripCalculator.calculateCo2Consumption(new Route(25, 88, "test", 1), null))).equals("3.324"));
    }

    @Test
    public void CO2ConsumptionFor1kmAnd50mSlopeReturns0() {
        assertTrue(tripCalculator.calculateCo2Consumption(new Route(1, -50, "test", 1), null) == 0);
    }

    @Test
    public void GravelroadIsDoubleHighway() {
        assertTrue(tripCalculator.calculateCo2Consumption(new Route(1, -50, "Highway", 1), null) * 2 == tripCalculator.calculateCo2Consumption(new Route(1, -50, "Gravelroad", 1), null));
    }

    @Test
    public void exampleCarCalculationReturns1comma458() {
        assertTrue(String.format(Locale.US, "%.3f", (tripCalculator.calculateCo2Consumption(new Route(10, 0, "test", 0), new Car(100, "test", 5)))).equals("1.458"));
    }

    @Test
    public void exampleTruckCalculationReturns1comma458() {
        assertTrue(String.format(Locale.US, "%.3f", (tripCalculator.calculateCo2Consumption(new Route(10, 0, "test", 0), new Truck(1000, "test", 5, false, 3)))).equals("1.458"));
    }
}