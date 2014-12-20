public class Vehicle extends FuelTypes{

    private double averageConsumption;
    private FuelType typeOfFuel;
    private int cargo;

    public Vehicle(int cargo, String typeOfFuel, double averageConsumption) {
        this.cargo = cargo;
        this.typeOfFuel = getFuelTypeFormString(typeOfFuel);
        this.averageConsumption = averageConsumption;
    }

    private FuelType getFuelTypeFormString(String type)
    {
        if(type.equalsIgnoreCase("diesel"))
        {
            return FuelType.DIESEL;
        }
        if(type.equalsIgnoreCase("patrol"))
        {
            return FuelType.PATROL;
        }
        return FuelType.UNDEFINED;
    }
}
