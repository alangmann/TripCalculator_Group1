package tripcalculator.vehicle;

import tripcalculator.fuel.FuelTypes;

public class Vehicle extends FuelTypes {

    private double averageConsumption;
    private FuelType typeOfFuel;
    private int cargo;

    public Vehicle(int cargo, String typeOfFuel, double averageConsumption) {
        this.cargo = cargo;
        this.typeOfFuel = getFuelTypeFormString(typeOfFuel);
        this.averageConsumption = averageConsumption;
    }

    public double getAverageConsumption() {
        return averageConsumption;
    }

    public FuelType getTypeOfFuel() {
        return typeOfFuel;
    }

    public int getCargo() {
        return cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        if (Double.compare(vehicle.averageConsumption, averageConsumption) != 0) return false;
        if (cargo != vehicle.cargo) return false;
        if (typeOfFuel != vehicle.typeOfFuel) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(averageConsumption);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + typeOfFuel.hashCode();
        result = 31 * result + cargo;
        return result;
    }
}
