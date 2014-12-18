import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertTrue;

public class RouteTest extends RouteTypes{

    private Route testRoute = new Route(10, 5, "Highway", 5);

    @Test
    public void routeReturns10km() {
        assertTrue(testRoute.getKm() == 10);
    }

    @Test
    public void routeReturns5Slope() {
        assertTrue(testRoute.getSlope() == 5);
    }

    @Test
    public void routeReturnsHighway() {
        assertTrue(RouteType.HIGHWAY.equals(testRoute.getType()));
    }

    @Test
    public void routeReturns5Fee() {
        assertTrue(testRoute.getFee() == 5);
    }

    @Test
    public void CO2ConsumptionFor10kmAnd5mSlopeReturns1comma325() {
        assertTrue(String.format(Locale.US, "%.3f", (new Route(10, 5, "test", 1).getCO2Consumption())).equals("1.326"));
    }

    @Test
    public void CO2ConsumptionFor20kmAnd5mSlopeReturns2comma640() {
        assertTrue(String.format(Locale.US, "%.3f", (new Route(20, 5, "test", 1).getCO2Consumption())).equals("2.651"));
    }

    @Test
    public void CO2ConsumptionFor25kmAnd88mSlopeReturns3comma324() {
        assertTrue(String.format(Locale.US, "%.3f", (new Route(25, 88, "test", 1).getCO2Consumption())).equals("3.324"));
    }

    @Test
    public void CO2ConsumptionFor1kmAnd50mSlopeReturns0() {
        assertTrue(new Route(1, -50, "test", 1).getCO2Consumption()==0);
    }
}
