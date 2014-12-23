package tripcalculator.route;

public class Route extends RouteTypes {

    private double km;
    private double slope;
    private RouteType type;
    private double fee;

    public Route(double km, double slope, String type, double fee) {
        this.km = km;
        this.slope = slope;
        this.type = getRouteTypeFormString(type);
        this.fee = fee;
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
        return km + ";" + slope + ";" + type + ";" + fee;
    }
}
