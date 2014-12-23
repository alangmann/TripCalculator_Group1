package tripcalculator.route;

public class Route extends RouteTypes {

    private int routeID;
    private double km;
    private double slope;
    private RouteType type;
    private double fee;

    public Route(int routeID, double km, double slope, String type, double fee) {
        this.routeID = routeID;
        this.km = km;
        this.slope = slope;
        this.type = getRouteTypeFormString(type);
        this.fee = fee;
    }

    public int getRouteID() {
        return routeID;
    }

    public double getKm() {
        return km;
    }

    public double getFee() {
        return fee;
    }

    public RouteType getType() {
        return type;
    }

    public double getSlope() {
        return slope;
    }

    @Override
    public String toString() {
        return routeID + "";
    }

    public String getCbString()
    {
        return ((int)km) + "km " + ((int)slope) + "slope " + ((int)fee) + "€ fee";
    }
}
