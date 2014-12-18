import java.util.HashMap;

public class RouteTypes {
    protected HashMap<RouteType, Double> factorMap = new HashMap<>();

    protected enum RouteType {
        COUNTRYROAD, HIGHWAY, GRAVELROAD, UNDEFINED
    }

    {
        factorMap.put(RouteType.COUNTRYROAD, 1.2);
        factorMap.put(RouteType.HIGHWAY, 1.);
        factorMap.put(RouteType.GRAVELROAD, 2.);
    }
}
