package tripcalculator.vehicle;

public class Truck extends Vehicle{

    private int axles;
    private boolean adBlue;

    public Truck(int cargo, String typeOfFuel, double averageConsumption, boolean adBlue, int axles) {
        super(cargo, typeOfFuel, averageConsumption);
        this.adBlue = adBlue;
        this.axles = axles;
    }

    public int getAxles() {
        return axles;
    }

    public boolean isAdBlue() {
        return adBlue;
    }
}
