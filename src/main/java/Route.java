public class Route {

    private double km;
    private double slope;
    private String type;
    private double fee;

    public Route(double km, double slope, String type, double fee) {
        this.km = km;
        this.slope = slope;
        this.type = type;
        this.fee = fee;
    }

    public double getCO2Consumption()
    {
        double slopePercent = (slope * 1000) / km;
        if(slopePercent <= -5)
        {
            return 0;
        }
        return km * 0.1325 * (slope / (km * 1000) + 1);
    }

    public double getKm() {
        return km;
    }

    public double getFee() {
        return fee;
    }

    public String getType() {
        return type;
    }

    public double getSlope() {
        return slope;
    }

    @Override
    public String toString() {
        return "Route{" +
                "km=" + km +
                ", slope=" + slope +
                ", type='" + type + '\'' +
                ", fee=" + fee +
                '}';
    }
}
