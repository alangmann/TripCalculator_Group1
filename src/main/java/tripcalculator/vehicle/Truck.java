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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Truck)) return false;
        if (!super.equals(o)) return false;

        Truck truck = (Truck) o;

        if (adBlue != truck.adBlue) return false;
        if (axles != truck.axles) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + axles;
        result = 31 * result + (adBlue ? 1 : 0);
        return result;
    }

    public String whoAmI()
    {
        return "Truck";
    }

    @Override
    public String toString() {
        return super.toString() + ";" + axles + ";" + adBlue;
    }
}
