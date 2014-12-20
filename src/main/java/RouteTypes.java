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
        factorMap.put(RouteType.UNDEFINED, 1.);
    }

    protected RouteType getRouteTypeFormString(String type)
    {
        if(type.equalsIgnoreCase("countryroad"))
        {
            return RouteType.COUNTRYROAD;
        }
        if(type.equalsIgnoreCase("highway"))
        {
            return RouteType.HIGHWAY;
        }
        if(type.equalsIgnoreCase("gravelroad"))
        {
            return RouteType.GRAVELROAD;
        }
        return RouteType.UNDEFINED;
    }
}
