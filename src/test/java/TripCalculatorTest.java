import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertTrue;

public class TripCalculatorTest {

    private TripCalculator tripCalculator;

    @Before
    public void setup() {
        tripCalculator = TripCalculator.getInstance();
    }

    @Test
    public void loadRoutesWorks() {
        assertTrue(TripCalculator.getInstance().getRoutes().size() > 0);
    }

    @Test
    public void CO2ConsumptionFor10kmAnd5mSlopeReturns1comma325() {
        assertTrue(String.format(Locale.US, "%.3f", (tripCalculator.calculateCo2Consumption(new Route(10, 5, "test", 1)))).equals("1.326"));
    }

    @Test
    public void CO2ConsumptionFor20kmAnd5mSlopeReturns2comma640() {
        assertTrue(String.format(Locale.US, "%.3f", (tripCalculator.calculateCo2Consumption(new Route(20, 5, "test", 1)))).equals("2.651"));
    }

    @Test
    public void CO2ConsumptionFor25kmAnd88mSlopeReturns3comma324() {
        assertTrue(String.format(Locale.US, "%.3f", (tripCalculator.calculateCo2Consumption(new Route(25, 88, "test", 1)))).equals("3.324"));
    }

    @Test
    public void CO2ConsumptionFor1kmAnd50mSlopeReturns0() {
        assertTrue(tripCalculator.calculateCo2Consumption(new Route(1, -50, "test", 1)) == 0);
    }

    @Test
    public void GravelroadIsDoubleHighway() {
        assertTrue(tripCalculator.calculateCo2Consumption(new Route(1, -50, "Highway", 1))*2==tripCalculator.calculateCo2Consumption(new Route(1, -50, "Gravelroad", 1)));
    }

}