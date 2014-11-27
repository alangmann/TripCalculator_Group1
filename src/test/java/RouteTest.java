/**
 * Created by christoph on 11/27/2014.
 */
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RouteTest {

    private Route testRoute = new Route(10, 5, "Highway", 5);

    @Test
    public void routeReturns10km () {
        assertTrue(testRoute.getKm()==10);
    }

}
