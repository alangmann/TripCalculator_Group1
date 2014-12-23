import org.junit.Before;
import org.junit.Test;
import tripcalculator.route.Route;
import tripcalculator.route.RouteTypes;

import static org.junit.Assert.assertTrue;

public class RouteTest extends RouteTypes {

    private Route testRoute;

    @Before
    public void setUp() {
        testRoute = new Route(1, 10, 5, "Highway", 5);
    }

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
}
