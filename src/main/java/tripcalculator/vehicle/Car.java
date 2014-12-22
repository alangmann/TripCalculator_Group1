package tripcalculator.vehicle;

public class Car extends Vehicle{
    private String bla;

    public Car(int cargo, String typeOfFuel, double averageConsumption) {
        super(cargo, typeOfFuel, averageConsumption);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (bla != null ? bla.hashCode() : 0);
        return result;
    }
}
