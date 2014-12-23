package tripcalculator.vehicle;

public class Car extends Vehicle{

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
        return super.hashCode();
    }

    public String whoAmI()
    {
        return "Car";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
