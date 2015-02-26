package tripcalculator.vehicle;

import org.springframework.stereotype.Component;
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
        if (typeOfFuel == vehicle.typeOfFuel) return true;
        else return false;

    }

    public String whoAmI()
    {
        return "Vehicle";
    }

    @Override
    public String toString() {
        return averageConsumption + ";" + typeOfFuel + ";" + cargo;
    }
}
