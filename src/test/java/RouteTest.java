import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RouteTest {

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
        assertTrue("Highway".equals(testRoute.getType()));
    }

    @Test
    public void routeReturns5Fee() {
        assertTrue(testRoute.getFee() == 5);
    }

    @Test
    public void CO2ConsumptionFor10kmAnd5mSlopeReturns1comma325() {
        System.out.println(new Route(10, 5, "baum", 1).getCO2Consumption());
        assertTrue(String.format("%.3f", (new Route(10, 5, "baum", 1).getCO2Consumption())).equals("1.325"));
    }

    @Test
    public void CO2ConsumptionFor20kmAnd5mSlopeReturns2comma640() {
        System.out.println(new Route(20, 5, "baum", 1).getCO2Consumption());
        assertTrue(String.format("%.3f", (new Route(20, 5, "baum", 1).getCO2Consumption())).equals("2.650"));
    }
}
