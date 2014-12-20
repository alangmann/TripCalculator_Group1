public class Vehicle extends FuelTypes{

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
}
